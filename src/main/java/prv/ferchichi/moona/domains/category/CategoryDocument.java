package prv.ferchichi.moona.domains.category;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Document(collection = "categories")
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Getter
public class CategoryDocument {

	@Id
	private UUID id;
	private String name;
}
