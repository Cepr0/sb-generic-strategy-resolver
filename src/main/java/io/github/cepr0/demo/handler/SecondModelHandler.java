package io.github.cepr0.demo.handler;

import io.github.cepr0.demo.model.SecondModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SecondModelHandler implements ModelHandler<SecondModel> {
	@Override
	public void handle(SecondModel data) {
		log.info("[i] Handling a SecondModel: {}...", data);
	}
}
