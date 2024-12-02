package com.alkaid.API.base.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "card_codes")
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "code", nullable = true, length = 255)
    private String code;

    @Column(name = "duration_type", nullable = true, length = 10)
    private String durationType;

    @Column(name = "ranks", nullable = true, length = 10)
    private String rank;

    @Column(name = "is_used", nullable = true, length = 1)
    private boolean isUsed;
}
