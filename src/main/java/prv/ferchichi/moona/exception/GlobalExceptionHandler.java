package prv.ferchichi.moona.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import reactor.core.publisher.Mono;

@ControllerAdvice
public class GlobalExceptionHandler {

	  @ExceptionHandler(value = Exception.class)
	  public Mono<String> resourceNotFoundException(Exception ex, WebRequest request) {
	    return Mono.just(ex.getMessage());
	  }
}
