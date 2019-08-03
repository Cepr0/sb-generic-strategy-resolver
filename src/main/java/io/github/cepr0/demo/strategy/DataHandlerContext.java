package io.github.cepr0.demo.strategy;

import io.github.cepr0.demo.data.Data;
import io.github.cepr0.resolver.GenericStrategyResolver;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class DataHandlerContext {

	private final GenericStrategyResolver<DataHandlerStrategy, Data> resolver;

	public DataHandlerContext(Collection<DataHandlerStrategy> handlers) {
		resolver = new GenericStrategyResolver<>(handlers);
	}

	public Optional<Data> handle(Data data) {
		return resolver.resolve(data.getClass())
				.map(handler -> {
					//noinspection unchecked
					return handler.handle(data);
				});
	}
}
