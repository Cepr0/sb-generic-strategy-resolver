package io.github.cepr0.demo.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.extern.slf4j.Slf4j;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CUSTOM;

@Slf4j
public class ModelDataTypeIdResolver extends TypeIdResolverBase {

	@Override
	public JavaType typeFromId(DatabindContext context, String id) {
		TypeFactory typeFactory = TypeFactory.defaultInstance();
		try {
			ModelDataType modelDataType = ModelDataType.valueOf(id);
			return typeFactory.constructType(modelDataType.getModelDataType());
		} catch (IllegalArgumentException e) {
			log.warn("[w] Model data type is not defined: {}", id);
			return typeFactory.constructType(DefaultData.class);
		}
	}

	@Override
	public String idFromValue(Object value) {
		return idFromValueAndType(value, value.getClass());
	}

	@Override
	public String idFromValueAndType(Object value, Class<?> suggestedType) {
		return suggestedType.getName();
	}

	@Override
	public JsonTypeInfo.Id getMechanism() {
		return CUSTOM;
	}
}
