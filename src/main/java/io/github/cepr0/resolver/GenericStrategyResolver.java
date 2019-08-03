package io.github.cepr0.resolver;

import org.springframework.core.ResolvableType;
import org.springframework.lang.NonNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GenericStrategyResolver<T, D> {

	private final Map<Class<?>, T> strategies = new HashMap<>();

	public GenericStrategyResolver(@NonNull Collection<T> strategies) {
		for (T strategy : strategies) {
			ResolvableType strategyType = ResolvableType.forInstance(strategy);
			for (ResolvableType strategyInterface : strategyType.getInterfaces()) {
				for (ResolvableType strategyInterfaceGenericParameter : strategyInterface.getGenerics()) {
					this.strategies.put(strategyInterfaceGenericParameter.getRawClass(), strategy);
				}
			}
		}
	}

	public Optional<T> resolve(Class<? extends D> dataType) {
		return Optional.ofNullable((strategies.get(dataType)));
	}
}
