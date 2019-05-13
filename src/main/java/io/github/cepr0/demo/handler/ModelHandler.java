package io.github.cepr0.demo.handler;

import io.github.cepr0.demo.factory.GenericBean;
import io.github.cepr0.demo.model.ModelData;

public interface ModelHandler<T extends ModelData> extends GenericBean {
	void handle(T data);
}
