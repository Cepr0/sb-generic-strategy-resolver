package io.github.cepr0.resolver;

import org.springframework.stereotype.Component;

@Component
public class SecondSideStrategy implements SideStrategy<SecondSideData, SecondData>, SideHandler<SecondData> {
	@Override
	public String test(SecondData data) {
		return data.getSecond();
	}

	@Override
	public String side(SecondSideData data) {
		return data.getSecond();
	}

	@Override
	public void handle() {
		throw new UnsupportedOperationException();
	}
}
