package com.alkaid.API.base.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

/**
 * @Author: DreamDev
 * @Date: 2024/10/26
 * Time:22:18
 */
@Entity
@Table(name = "ban_user")
@Getter
@Setter
public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "username")
    private String username;

    @Column(name = "token")
    private String token;

}
