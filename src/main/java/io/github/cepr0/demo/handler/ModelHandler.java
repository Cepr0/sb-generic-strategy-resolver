package io.github.cepr0.demo.handler;

import io.github.cepr0.demo.model.ModelData;

public interface ModelHandler<T extends ModelData> {
	void handle(T data);
}
