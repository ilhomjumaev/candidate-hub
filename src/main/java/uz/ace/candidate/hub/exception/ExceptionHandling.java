package uz.ace.candidate.hub.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

@Slf4j
@ControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler
    public Mono<ResponseEntity<Object>> handleException(ServerHttpRequest request, Throwable ex) {
        log.warn("HandleException() remoteAddress: {}, message: {}", request.getRemoteAddress(), ex.getMessage());
        return Mono.fromCallable(() -> new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
