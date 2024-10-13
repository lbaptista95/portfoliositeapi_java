package com.lb.portfolio.api.handler;

import com.lb.portfolio.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class UserHandler extends MainHandler {

    private final UserService userService;

    public Mono<ServerResponse> handleRouteGetAllUsers(ServerRequest request) {
        return ok()
                .headers(defaultHeaders())
                .body(BodyInserters.fromValue(userService.findAllUsers()))
                .flatMap(mapResponse())
                .switchIfEmpty(mapNoContent())
                .onErrorResume(mapErrorResume());
    }

    public Mono<ServerResponse> handleRouteGetUserById(ServerRequest request) {
        String userId = request.pathVariable("id");

        return ok()
                .headers(defaultHeaders())
                .body(BodyInserters.fromValue(userService.findTopById(Integer.valueOf(userId))))
                .flatMap(mapResponse())
                .switchIfEmpty(mapNoContent())
                .onErrorResume(mapErrorResume());
    }
}
