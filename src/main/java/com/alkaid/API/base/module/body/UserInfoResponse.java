package com.alkaid.API.base.module.body;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class UserInfoResponse {
    private String username;
    private String password;
    private String rank;
    private Boolean Banned;
    private Boolean IsRegistered;
    private Boolean IsBeta;
    private String capeurl;
    private String skinurl;
    private String qq;
    private Date expirationDate;
}
