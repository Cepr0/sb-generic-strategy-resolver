package io.github.cepr0.resolver;

public interface TestStrategy<D extends TestData> {
	String test(D data);
}
