package io.github.cepr0.demo.data;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class DefaultData implements Data {

	final Map<String, String> props = new HashMap<>();

	@JsonAnySetter
	public void set(String key, String value) {
		props.put(key, value);
	}
}
