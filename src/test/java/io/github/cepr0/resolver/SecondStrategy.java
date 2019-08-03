package io.github.cepr0.resolver;

import org.springframework.stereotype.Component;

@Component
public class SecondStrategy implements TestStrategy<SecondData>, SideHandler<SecondData> {
	@Override
	public String test(SecondData data) {
		return data.getSecond();
	}

	@Override
	public void handle() {
		throw new UnsupportedOperationException();
	}
}
