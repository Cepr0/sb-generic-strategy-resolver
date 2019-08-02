package io.github.cepr0.demo.model;

import io.github.cepr0.demo.model.data.FirstTypeData;
import io.github.cepr0.demo.model.data.SecondTypeData;
import lombok.Getter;

public enum ModelDataType {

	FIRST(FirstTypeData.class),
	SECOND(SecondTypeData.class);

	@Getter
	private final Class<? extends ModelData> modelDataType;

	ModelDataType(Class<? extends ModelData> modelDataType) {
		this.modelDataType = modelDataType;
	}
}
