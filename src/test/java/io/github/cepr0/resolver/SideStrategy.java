package io.github.cepr0.resolver;

public interface SideStrategy<S extends SideData, D extends TestData> {
	String test(D data);
	String side(S data);
}
