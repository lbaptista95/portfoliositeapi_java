package com.lb.portfolio.api.exception.handler;

import com.lb.portfolio.api.exception.PortfolioException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Log4j2
@RestController
@ControllerAdvice
public class ResponseExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<PortfolioException> handleMethodArgumentException(MethodArgumentTypeMismatchException e) {
        return ResponseEntity.badRequest().body(new PortfolioException(e.getMessage()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<PortfolioException> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(new PortfolioException(e.getMessage()));
    }

    @ExceptionHandler(value = PortfolioException.class)
    public ResponseEntity<PortfolioException> handleException(PortfolioException e) {
        return ResponseEntity.status(e.getCode()).body(e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<PortfolioException> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new PortfolioException(e.getMessage()));
    }
}
