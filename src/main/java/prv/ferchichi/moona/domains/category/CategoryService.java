package prv.ferchichi.moona.domains.category;

import static prv.ferchichi.moona.exception.MoonaExceptionType.NOT_FOUND;

import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import prv.ferchichi.moona.exception.MoonaExceptionFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@RequiredArgsConstructor
public class CategoryService {

	private final CategoryRepository repository;
	private final MoonaExceptionFactory exceptionFactory;
	
	public Flux<CategoryResponse> findAll() {
		return repository.findAll().map(document -> new CategoryResponse(document.getName()));
	}
	
	public Mono<UUID> createOne(CategoryParam category) {
		return repository.save(new CategoryDocument(UUID.randomUUID(), category.getName())).map(CategoryDocument::getId);
	}

	public Mono<CategoryResponse> findOne(UUID id) {
		return repository.findById(id)
				.map(document -> new CategoryResponse(document.getName()))
				.switchIfEmpty(Mono.error(exceptionFactory.create(NOT_FOUND, CategoryDocument.class, id)))
				;
	}

	public Mono<Long> createMany(Set<CategoryParam> categories) {
		return repository
					.insert(categories.stream().map(dto -> new CategoryDocument(UUID.randomUUID(), dto.getName())).toList())
					.count();
	}
}
