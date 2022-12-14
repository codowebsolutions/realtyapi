package com.example.realtyapi;


import com.example.realtyapi.model.domain.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AccountRepository extends ReactiveCrudRepository<Account, String> {

    Mono<Account> findByUsername(String username);



}
