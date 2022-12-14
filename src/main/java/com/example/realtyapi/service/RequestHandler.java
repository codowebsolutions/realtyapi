package com.example.realtyapi.service;


import com.example.realtyapi.model.request.AccountRequest;
import com.example.realtyapi.model.response.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Service
public class RequestHandler {

    @Autowired
    AccountRequestHandler accountHandler;

    public Mono<ServerResponse> getAccounts(ServerRequest serverRequest) {
        return accountHandler.getAccounts().flatMap(resp -> ok().bodyValue(resp));
    }

    public Mono<ServerResponse> login(ServerRequest serverRequest) {
        Mono<AccountRequest> accountRequestMono = serverRequest.bodyToMono(AccountRequest.class);

        return accountRequestMono.flatMap(req ->
                accountHandler.login(req.getUsername(), req.getPassword())
                        .flatMap(accountResponse -> ok().bodyValue(accountResponse)));


    }

}
