package io.github.cepr0.demo.resolver;

import org.springframework.core.ResolvableType;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public class GenericStrategyResolver<T, D> {

	private final Collection<? extends T> strategies;

	public GenericStrategyResolver(Collection<? extends T> strategies) {
		this.strategies = strategies;
	}

	public Optional<? extends T> get(Class<? extends D> dataType) {
		return strategies.stream()
				.filter(strategy -> {

					ResolvableType strategyType = ResolvableType.forInstance(strategy);

					return Stream.of(strategyType.getInterfaces()).anyMatch(strategyInterface -> {

						boolean isStrategyImplementsT = strategyInterface.isInstance(strategy);

						boolean isStrategyGenericParameterImplementsD = Stream
								.of(strategyInterface.getGenerics())
								.anyMatch(strategyInterfaceType -> strategyInterfaceType.isAssignableFrom(dataType));

						return isStrategyImplementsT && isStrategyGenericParameterImplementsD;
					});
				})
				.findFirst();
	}
}
