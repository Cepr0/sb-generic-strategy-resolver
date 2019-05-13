package io.github.cepr0.demo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.cepr0.demo.model.FirstModel;
import io.github.cepr0.demo.model.ModelData;
import io.github.cepr0.demo.model.SecondModel;
import lombok.Value;

import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.EXTERNAL_PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@Value
public class ModelDto<T extends ModelData> {

	@NotNull
	private String type;

	@NotNull
	@JsonTypeInfo(use = NAME, include = EXTERNAL_PROPERTY, property = "type")
	@JsonSubTypes({
			@Type(value = FirstModel.class, name = "FIRST"),
			@Type(value = SecondModel.class, name = "SECOND")
	})
	private T data;
}
