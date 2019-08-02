package io.github.cepr0.demo.handler.impl;

import io.github.cepr0.demo.handler.ModelHandler;
import io.github.cepr0.demo.model.data.SecondTypeData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SecondTypeDataHandler implements ModelHandler<SecondTypeData> {
	@Override
	public void handle(SecondTypeData data) {
		log.info("[i] Handling a SecondModel: {}...", data);
	}
}
