package com.platform.commerceservice.exception;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(CallNotPermittedException.class)
  public ResponseEntity<String> handleCircuitBreakerException1(Throwable t) {
    return ResponseEntity.internalServerError()
        .body( "fallback invoked! exception type : " + t.getClass());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleCircuitBreakerException2(Throwable t) {
    return ResponseEntity.internalServerError()
        .body( "fallback invoked! exception type : " + t.getClass());
  }
}
