package io.github.cepr0.demo.handler;

import io.github.cepr0.demo.model.FirstModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FirstModelHandler implements ModelHandler<FirstModel> {
	@Override
	public void handle(FirstModel data) {
		log.info("[i] Handing a FirstModel: {}...", data);
	}
}

