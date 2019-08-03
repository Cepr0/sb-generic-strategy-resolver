package io.github.cepr0.demo.data;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.extern.slf4j.Slf4j;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CUSTOM;

@Slf4j
public class DataTypeIdResolver extends TypeIdResolverBase {

	@Override
	public JavaType typeFromId(DatabindContext context, String id) {
		TypeFactory typeFactory = TypeFactory.defaultInstance();
		try {
			DataType dataType = DataType.valueOf(id);
			return typeFactory.constructType(dataType.getType());
		} catch (IllegalArgumentException e) {
			log.warn("[w] Data type is not defined: {}", id);
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
