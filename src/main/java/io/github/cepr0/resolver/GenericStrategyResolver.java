package io.github.cepr0.resolver;

import org.springframework.core.ResolvableType;
import org.springframework.lang.NonNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GenericStrategyResolver<T, D> {

	private final Map<Class<?>, T> beans = new HashMap<>();

	public GenericStrategyResolver(@NonNull Collection<T> beans) {
		for (T bean : beans) {
			ResolvableType beanType = ResolvableType.forInstance(bean);
			for (ResolvableType beanInterface : beanType.getInterfaces()) {
				for (ResolvableType beanInterfaceGenericParameter : beanInterface.getGenerics()) {
					this.beans.put(beanInterfaceGenericParameter.getRawClass(), bean);
				}
			}
		}
	}

	public Optional<T> resolve(Class<? extends D> dataType) {
		return Optional.ofNullable((beans.get(dataType)));
	}
}
