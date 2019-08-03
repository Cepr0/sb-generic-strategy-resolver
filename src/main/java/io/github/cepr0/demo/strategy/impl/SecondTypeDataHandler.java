package io.github.cepr0.demo.strategy.impl;

import io.github.cepr0.demo.data.impl.SecondTypeData;
import io.github.cepr0.demo.strategy.DataHandlerStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SecondTypeDataHandler implements DataHandlerStrategy<SecondTypeData> {
	@Override
	public SecondTypeData handle(SecondTypeData data) {
		log.info("[i] Handling a Second type data: {}...", data);
		return data;
	}
}
