package com.lb.portfolio.api.handler;

import com.lb.portfolio.api.exception.PortfolioException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.springframework.web.reactive.function.server.ServerResponse.*;

public abstract class MainHandler {

    Consumer<HttpHeaders> defaultHeaders() {
        return headers -> {
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set(HttpHeaders.CONTENT_ENCODING, StandardCharsets.UTF_8.name());
        };
    }

    Function<ServerResponse, Mono<? extends ServerResponse>> mapResponse() {
        return response -> {
            if (response.statusCode().isError())
                return Mono.error(new PortfolioException(HttpStatus.valueOf(response.statusCode().value())));

            return Mono.just(response);
        };
    }

    Function<Throwable, Mono<? extends ServerResponse>> mapErrorResume() {
        return e -> Mono.just(String.format("Error: %s", e.getMessage()))
                .flatMap(s -> badRequest().contentType(MediaType.TEXT_PLAIN).bodyValue(s));
    }

    Mono<ServerResponse> mapNoContent() {
        return noContent().build();
    }

    Mono<ServerResponse> mapBadRequest() {
        return badRequest().bodyValue(new PortfolioException(HttpStatus.BAD_REQUEST));
    }

    Mono<ServerResponse> mapNotFound() {
        return status(HttpStatus.NOT_FOUND).bodyValue(new PortfolioException(HttpStatus.NOT_FOUND));
    }

    Mono<ServerResponse> mapInternalServerError() {
        return status(HttpStatus.INTERNAL_SERVER_ERROR).bodyValue(new PortfolioException(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
