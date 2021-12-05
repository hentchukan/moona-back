package prv.ferchichi.moona.domains.category;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/v1/categories")
public class CategoryController {

	private final CategoryService service;
	
	@GetMapping("")
	public Flux<CategoryResponse> all() {
		return service.findAll();
	}
	
	@PostMapping(consumes = "application/json")
	public Mono<ResponseEntity<Void>> createOne(@RequestBody CategoryParam param) {
		return service
					.createOne(param)
					.map(uuid -> ResponseEntity
							.created(URI.create("/v1/categories/"+uuid.toString()))
							.build());
	}
}
