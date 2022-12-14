package com.example.realtyapi.routes;

import com.example.realtyapi.service.RequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class RouterConfiguration {


    @Bean
    public RouterFunction<ServerResponse> defaultRoutes(RequestHandler requestHandler){
        RouterFunction<ServerResponse> account = RouterFunctions.route(GET("/accounts"), requestHandler::getAccounts);
        RouterFunction<ServerResponse> login = RouterFunctions.route(POST("/account/login"), requestHandler::login);
        return account.and(login);
    }


}
