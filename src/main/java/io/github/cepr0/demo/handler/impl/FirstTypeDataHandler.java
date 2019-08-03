package io.github.cepr0.demo.handler.impl;

import io.github.cepr0.demo.data.impl.FirstTypeData;
import io.github.cepr0.demo.handler.DataHandlerStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FirstTypeDataHandler implements DataHandlerStrategy<FirstTypeData> {
	@Override
	public FirstTypeData handle(FirstTypeData data) {
		log.info("[i] Handing a First type data: {}...", data);
		return data;
	}
}

