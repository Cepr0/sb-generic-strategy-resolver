package io.github.cepr0.resolver;

import org.springframework.stereotype.Component;

@Component
public class FirstStrategy implements TestStrategy<FirstData> {
	@Override
	public String test(FirstData data) {
		return data.getFirst();
	}
}
