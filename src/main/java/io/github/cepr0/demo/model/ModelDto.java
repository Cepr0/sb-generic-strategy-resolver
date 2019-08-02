package io.github.cepr0.demo.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import lombok.Data;

import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.EXTERNAL_PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CUSTOM;

@Data
public class ModelDto<T extends ModelData> {

	@NotNull
	private String type;

	@NotNull
	@JsonTypeInfo(use = CUSTOM, include = EXTERNAL_PROPERTY, property = "type")
	@JsonTypeIdResolver(ModelDataTypeIdResolver.class)
	private T data;

}
