package com.alkaid.API.base.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "user_accounts")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "account_id")
    private String username;
    @Column(name = "account_password")
    private String password;
    @Column(name = "token")
    private String token;
    @Column(name = "ranks")
    private String ranks;
    @Column(name = "beta")
    private Boolean isbeta;
    @Column(name = "expiration_date")
    private Date expiration_date;
    @Column(name = "capeurl")
    private String capeurl;
    @Column(name = "skinurl")
    private String skinurl;
}
