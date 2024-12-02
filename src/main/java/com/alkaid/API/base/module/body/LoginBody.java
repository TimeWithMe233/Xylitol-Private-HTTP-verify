package com.alkaid.API.base.module.body;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginBody {
    private String username;
    private String password;
    private String token;
}
