package io.github.cepr0.demo;

import io.github.cepr0.demo.model.ModelData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/models")
public class ModelController {

	private final ModelHandlerFactory handlerFactory;

	public ModelController(ModelHandlerFactory handlerFactory) {
		this.handlerFactory = handlerFactory;
	}

	@PostMapping
	public <T extends ModelData> ResponseEntity post(@RequestBody ModelDto<T> dto) {
		T data = dto.getData();
		return handlerFactory.get(data.getClass())
				.map(handler -> {
					//noinspection unchecked
					handler.handle(data);
					return ResponseEntity.ok().build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
