package io.github.cepr0.demo;

import io.github.cepr0.demo.data.Data;
import io.github.cepr0.demo.data.DataTO;
import io.github.cepr0.demo.resolver.GenericStrategyResolver;
import io.github.cepr0.demo.strategy.DataHandlerStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/data")
public class DataController {

	private final GenericStrategyResolver<DataHandlerStrategy, Data> dataHandlerResolver;

	public DataController(GenericStrategyResolver<DataHandlerStrategy, Data> dataHandlerResolver) {
		this.dataHandlerResolver = dataHandlerResolver;
	}

	@PostMapping
	public <D extends Data> ResponseEntity post(@RequestBody DataTO<D> dto) {
		D data = dto.getData();
		return dataHandlerResolver.get(data.getClass())
				.map(handler -> {
					//noinspection unchecked
					Data result = handler.handle(data);
					return ResponseEntity.ok(result);
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
