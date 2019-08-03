package io.github.cepr0.resolver;

import org.springframework.stereotype.Component;

@Component
public class FirstSideStrategy implements SideStrategy<FirstSideData, FirstData> {
	@Override
	public String test(FirstData data) {
		return data.getFirst();
	}

	@Override
	public String side(FirstSideData data) {
		return data.getFirst();
	}
}
