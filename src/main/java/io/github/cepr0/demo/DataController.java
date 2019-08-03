package io.github.cepr0.demo;

import io.github.cepr0.demo.data.Data;
import io.github.cepr0.demo.data.DataTO;
import io.github.cepr0.demo.strategy.DataHandlerContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

	private final DataHandlerContext dataHandlerContext;

	public DataController(DataHandlerContext dataHandlerContext) {
		this.dataHandlerContext = dataHandlerContext;
	}

	@PostMapping
	public ResponseEntity post(@RequestBody DataTO<Data> dto) {
		return dataHandlerContext.handle(dto.getData())
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
