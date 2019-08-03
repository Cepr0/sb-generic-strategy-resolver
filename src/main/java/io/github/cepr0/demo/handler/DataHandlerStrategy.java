package io.github.cepr0.demo.handler;

import io.github.cepr0.demo.data.Data;

public interface DataHandlerStrategy<D extends Data> {
	D handle(D data);
}
