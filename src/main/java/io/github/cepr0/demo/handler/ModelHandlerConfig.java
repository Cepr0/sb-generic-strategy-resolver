package io.github.cepr0.demo.handler;

import io.github.cepr0.demo.factory.HandlerFactory;
import io.github.cepr0.demo.model.ModelData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class ModelHandlerConfig {
	@Bean
	public HandlerFactory<ModelHandler, ModelData> handlerFactory(Set<ModelHandler> handlers) {
		return new HandlerFactory<>(handlers);
	}
}
