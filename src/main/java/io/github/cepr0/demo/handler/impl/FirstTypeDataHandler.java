package io.github.cepr0.demo.handler.impl;

import io.github.cepr0.demo.handler.ModelHandler;
import io.github.cepr0.demo.model.data.FirstTypeData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FirstTypeDataHandler implements ModelHandler<FirstTypeData> {
	@Override
	public void handle(FirstTypeData data) {
		log.info("[i] Handing a FirstModel: {}...", data);
	}
}

