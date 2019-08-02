package io.github.cepr0.demo.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class DefaultData implements ModelData {

	final Map<String, String> props = new HashMap<>();

	@JsonAnySetter
	public void set(String key, String value) {
		props.put(key, value);
	}
}
