package com.example.realtyapi.service;

import com.example.realtyapi.AccountRepository;
import com.example.realtyapi.model.domain.Account;
import com.example.realtyapi.model.response.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AccountRequestHandler {

    @Autowired
    AccountRepository accountRepository;


    public Mono<List<Account>> getAccounts() {
        return accountRepository.findAll().collectList().switchIfEmpty(Mono.empty());
    }

    public Mono<AccountResponse> login(String username, String password) {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setPasswordMatch(false);//default to false
        return accountRepository.findByUsername(username)
                .map(resp -> {
                    if (resp.getPassword().equalsIgnoreCase(password)) {
                        accountResponse.setUsername(username);
                        accountResponse.setPasswordMatch(true);
                    }
                    return accountResponse;
                }).switchIfEmpty(Mono.just(accountResponse));

    }
}
