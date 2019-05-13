package io.github.cepr0.demo;

import io.github.cepr0.demo.factory.GenericFactory;
import io.github.cepr0.demo.handler.ModelHandler;
import io.github.cepr0.demo.model.ModelData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelHandlerFactory extends GenericFactory<ModelHandler, ModelData> {

	public ModelHandlerFactory(List<ModelHandler> beans) {
		super(beans, ModelHandler.class);
	}
}
