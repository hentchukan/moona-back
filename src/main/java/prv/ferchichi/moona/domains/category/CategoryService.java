package prv.ferchichi.moona.domains.category;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CategoryService {

	private final CategoryRepository repository;
	
	public Flux<CategoryResponse> findAll() {
		return repository.findAll().map(document -> new CategoryResponse(document.getName()));
	}
	
	public Mono<UUID> createOne(CategoryParam category) {
		return repository.save(new CategoryDocument(UUID.randomUUID(), category.getName())).map(document -> document.getId());
	}
}
