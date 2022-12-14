package com.example.realtyapi.model.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Account {

    @Id
    private String id;

    private String first_name;
    private String last_name;
    private String password;
    private String username;


}