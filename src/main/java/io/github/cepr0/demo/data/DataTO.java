package io.github.cepr0.demo.data;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import lombok.Value;

import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.EXTERNAL_PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CUSTOM;

@Value
public class DataTO<T extends Data> {

	@NotNull
	private String type;

	@NotNull
	@JsonTypeInfo(use = CUSTOM, include = EXTERNAL_PROPERTY, property = "type")
	@JsonTypeIdResolver(DataTypeIdResolver.class)
	private T data;
}
