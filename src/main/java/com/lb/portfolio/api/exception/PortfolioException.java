package com.lb.portfolio.api.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;

import javax.naming.AuthenticationException;

@Getter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true, value = {"cause", "stackTrace", "suppressed"})
public class PortfolioException extends RuntimeException {

    private final Integer code;
    @JsonProperty("error_message")
    private final String errorMessage;

    public PortfolioException(final HttpStatus status, final AuthenticationException exception) {
        this.code = status.value();
        this.errorMessage = exception.getMessage();
    }

    public PortfolioException(final HttpStatus httpStatus) {
        this.code = httpStatus.value();
        this.errorMessage = httpStatus.getReasonPhrase();
    }

    public PortfolioException(final String errorMessage) {
        this.code = null;
        this.errorMessage = errorMessage;
    }

    public PortfolioException(final HttpStatus httpStatus, final String errorMessage) {
        this.code = httpStatus.value();
        this.errorMessage = errorMessage;
    }

    public PortfolioException(final Integer code, final String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public PortfolioException(final String message, final Integer code, final String errorMessage) {
        super(message);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public PortfolioException(final String message, final Throwable cause, final Integer code, final String errorMessage) {
        super(message, cause);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public PortfolioException(final Throwable cause, final Integer code, final String errorMessage) {
        super(cause);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public PortfolioException(final String message, final Throwable cause, final boolean enableSuppression,
                              final boolean writableStackTrace, final Integer code, final String errorMessage) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    @Override
    @SneakyThrows
    public String toString() {
        return new ObjectMapper().writeValueAsString(this);
    }
}
