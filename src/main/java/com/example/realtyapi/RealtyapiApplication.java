package com.example.realtyapi;

import com.example.realtyapi.model.domain.Account;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealtyapiApplication {

    public static void main(String[] args) {

        Account account = new Account();
        account.setId("3242");

        System.out.println(account.getId());

        SpringApplication.run(RealtyapiApplication.class, args);
    }

}
