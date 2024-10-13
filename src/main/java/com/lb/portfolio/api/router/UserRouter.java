package com.lb.portfolio.api.router;

import com.lb.portfolio.api.handler.UserHandler;
import com.lb.portfolio.api.service.UserService;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class UserRouter {

    @Bean
    @RouterOperation(beanClass = UserService.class, beanMethod = "findAllUsers")
    public RouterFunction<ServerResponse> routeAllUsers(UserHandler handler) {
        return RouterFunctions.route(GET("/user/all"), handler::handleRouteGetAllUsers);
    }

    @Bean
    @RouterOperation(beanClass = UserService.class, beanMethod = "findTopById")
    public RouterFunction<ServerResponse> routeUserById(UserHandler handler) {
        return RouterFunctions.route(GET("/user"), handler::handleRouteGetUserById);
    }
}
