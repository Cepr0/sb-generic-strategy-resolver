package io.github.cepr0.demo.handler;

import io.github.cepr0.demo.data.Data;
import io.github.cepr0.demo.resolver.GenericStrategyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Configuration
public class DataHandlerContext {
	@Bean
	public GenericStrategyResolver<DataHandlerStrategy, Data> handlerResolver(Collection<DataHandlerStrategy> handlers) {
		return new GenericStrategyResolver<>(handlers);
	}
}
