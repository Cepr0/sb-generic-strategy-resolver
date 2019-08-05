# Spring GenericStrategyResolver

[GenericStrategyResolver][4] makes it possible to 'resolve' generic [Strategy][1] implementations by its generic parameter.

Assume we have some generic strategy:

```java
public interface TestStrategy<D extends TestData> {
   String test(D data);
}
``` 
its generic parameter interface:
```java
public interface TestData {
}
``` 
two implementations of `TestData`:
```java
@Value
public class FirstData implements TestData {
   private String first;
}

@Value
public class SecondData implements TestData {
   private String second;
}
```
and their implementations of `TestStrategy`:
```java
@Component
public class FirstStrategy implements TestStrategy<FirstData> {
   @Override
   public String test(FirstData data) {
      return data.getFirst();
   }
}

@Component
public class SecondStrategy implements TestStrategy<SecondData> {
   @Override
   public String test(SecondData data) {
      return data.getSecond();
   }
}
```
Now if we register `GenericStrategyResolver` bean:
```java
@Bean
public GenericStrategyResolver<TestStrategy, TestData> resolver(Collection<TestStrategy> strategies) {
   return new GenericStrategyResolver<>(strategies);
}
```
we will be able to get a concrete strategy by its generic parameter type:
```java
@Component
public class TestStrategyContext {

   private final GenericStrategyResolver<TestStrategy, TestData> resolver;
 
   public TestStrategyContext(GenericStrategyResolver<TestStrategy, TestData> resolver) {
      this.resolver = resolver;  
   }

   public Optional<String> test(TestData data) {
      return resolver.resolve(data.getClass())
            .map(strategy -> {
               //noinspection unchecked
               return strategy.test(data);
            });
   }
}
```

See the usage example of `GenericStrategyResolver` in the package [demo][2] - it's a simple
REST service that takes POST requests with a different data and produces the different responses
and logging depends on the input data. Requests examples can be found in the [demo.http][3] 
(you can run they right there, if you are using Intellij IDEA).   

[1]: https://en.wikipedia.org/wiki/Strategy_pattern
[2]: src/main/java/io/github/cepr0/demo
[3]: demo.http
[4]: src/main/java/io/github/cepr0/resolver/GenericStrategyResolver.java