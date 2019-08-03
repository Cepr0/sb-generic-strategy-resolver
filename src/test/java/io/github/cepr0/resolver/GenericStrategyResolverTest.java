package io.github.cepr0.resolver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class GenericStrategyResolverTest {

	@Autowired
	private GenericStrategyResolver<TestStrategy, TestData> resolver1;

	@Autowired
	private GenericStrategyResolver<SideStrategy, TestData> resolver2;

	@Autowired
	private GenericStrategyResolver<SideStrategy, SideData> resolver3;

	@Test
	public void testStrategy() {
		assertThat(resolver1.resolve(FirstData.class)).containsInstanceOf(FirstStrategy.class);
		assertThat(resolver1.resolve(SecondData.class)).containsInstanceOf(SecondStrategy.class);
		assertThat(resolver1.resolve(TestData.class)).isEmpty();
	}

	@Test
	public void sideStrategyTestData() {
		assertThat(resolver2.resolve(FirstData.class)).containsInstanceOf(FirstSideStrategy.class);
		assertThat(resolver2.resolve(SecondData.class)).containsInstanceOf(SecondSideStrategy.class);
		assertThat(resolver2.resolve(TestData.class)).isEmpty();
	}

	@Test
	public void sideStrategySideData() {
		assertThat(resolver3.resolve(FirstSideData.class)).containsInstanceOf(FirstSideStrategy.class);
		assertThat(resolver3.resolve(SecondSideData.class)).containsInstanceOf(SecondSideStrategy.class);
		assertThat(resolver3.resolve(SideData.class)).isEmpty();
	}

	@Configuration
	@ComponentScan
	static class Config {
		@Bean
		public GenericStrategyResolver<TestStrategy, TestData> resolver(Collection<TestStrategy> strategies) {
			return new GenericStrategyResolver<>(strategies);
		}

		@Bean
		public GenericStrategyResolver<SideStrategy, TestData> dataResolver(Collection<SideStrategy> strategies) {
			return new GenericStrategyResolver<>(strategies);
		}

		@Bean
		public GenericStrategyResolver<SideStrategy, SideData> sideResolver(Collection<SideStrategy> strategies) {
			return new GenericStrategyResolver<>(strategies);
		}
	}
}