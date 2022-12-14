package com.example.realtyapi.model.response;

import lombok.Data;

@Data
public class AccountResponse {

    private String username;
    private boolean passwordMatch;

}
