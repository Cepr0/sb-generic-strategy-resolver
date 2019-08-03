package io.github.cepr0.demo.data;

import io.github.cepr0.demo.data.impl.FirstTypeData;
import io.github.cepr0.demo.data.impl.SecondTypeData;
import lombok.Getter;

public enum DataType {

	FIRST(FirstTypeData.class),
	SECOND(SecondTypeData.class);

	@Getter
	private final Class<? extends Data> type;

	DataType(Class<? extends Data> type) {
		this.type = type;
	}
}
