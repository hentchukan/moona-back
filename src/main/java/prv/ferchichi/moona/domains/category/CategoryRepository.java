package prv.ferchichi.moona.domains.category;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface CategoryRepository extends ReactiveMongoRepository<CategoryDocument, UUID> {
	
	public Flux<CategoryDocument> findAll();
	public Flux<CategoryDocument> findByNameIn(List<String> names);
	
}
