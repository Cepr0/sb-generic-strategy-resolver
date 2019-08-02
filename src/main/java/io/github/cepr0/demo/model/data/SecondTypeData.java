package io.github.cepr0.demo.model.data;

import io.github.cepr0.demo.model.ModelData;
import lombok.Value;

@Value
public class SecondTypeData implements ModelData {
	private String second;
}
