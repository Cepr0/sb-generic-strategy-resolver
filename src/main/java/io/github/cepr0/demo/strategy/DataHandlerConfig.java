package io.github.cepr0.demo.strategy;

import io.github.cepr0.demo.data.Data;
import io.github.cepr0.resolver.GenericStrategyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Configuration
public class DataHandlerConfig {
	@Bean
	public GenericStrategyResolver<DataHandlerStrategy, Data> handlerResolver(Collection<DataHandlerStrategy> handlers) {
		return new GenericStrategyResolver<>(handlers);
	}
}
