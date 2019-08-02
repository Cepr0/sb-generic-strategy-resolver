package io.github.cepr0.demo.factory;

import org.springframework.core.ResolvableType;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class HandlerFactory<T, D> {

	private final Set<? extends T> handlers;

	public HandlerFactory(Set<? extends T> handlers) {
		this.handlers = handlers;
	}

	public Optional<? extends T> get(Class<? extends D> dataType) {
		return handlers.stream()
				.filter(handler -> {
					ResolvableType handlerType = ResolvableType.forInstance(handler);
					return Stream.of(handlerType.getInterfaces()).anyMatch(iFace -> {
						boolean a = iFace.isInstance(handler);
						boolean b = Stream.of(iFace.getGenerics()).anyMatch(ifType -> ifType.isAssignableFrom(dataType));
						return a && b;
					});
				})
				.findFirst();
	}
}
