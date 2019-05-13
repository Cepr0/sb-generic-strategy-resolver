package io.github.cepr0.demo.factory;

import org.springframework.core.ResolvableType;

import java.util.List;
import java.util.Optional;

public abstract class GenericFactory<B extends GenericBean, T> {

	private final List<? extends B> genericBeans;
	private final Class<B> genericBeanClass;

	public GenericFactory(List<? extends B> genericBeans, Class<B> genericBeanClass) {
		this.genericBeans = genericBeans;
		this.genericBeanClass = genericBeanClass;
	}

	public Optional<? extends B> get(Class<? extends T> typeClass) {
		ResolvableType genericBeanType = ResolvableType.forClassWithGenerics(genericBeanClass, typeClass);
		return genericBeans.stream()
				.filter(genericBeanType::isInstance)
				.findFirst();
	}
}
