package prv.ferchichi.moona.exception;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class MoonaExceptionFactory {

	public Throwable create(MoonaExceptionType type, Class<?> clazz, UUID id) {
		return switch (type) {
		case NOT_FOUND: {
			yield new MoonaException(
					String.format("Object %s with id %s not found.", clazz.getSimpleName(), id.toString()), HttpStatus.NOT_FOUND);
		}
		case DUPLICATE: {
			yield new MoonaException(
					String.format("Object %s with id %s already exists.", clazz.getSimpleName(), id.toString()), HttpStatus.CONFLICT);
		}
		default:
			yield new MoonaException(String.format("Unexpected value: %s", id), HttpStatus.UNPROCESSABLE_ENTITY);
		};
	}

}
