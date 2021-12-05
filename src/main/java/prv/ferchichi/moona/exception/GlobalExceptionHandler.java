package prv.ferchichi.moona.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import reactor.core.publisher.Mono;

@ControllerAdvice
public class GlobalExceptionHandler {

	  @ExceptionHandler(value = MoonaException.class)
	  public Mono<ResponseEntity<String>> resourceNotFoundException(MoonaException ex) {
	    return Mono.just(new ResponseEntity<>(ex.getMessage(), ex.getType()));
	  }
}
