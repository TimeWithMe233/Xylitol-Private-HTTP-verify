package com.alkaid.API.base.module.body;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardBody {
    private String time;
    private int count;
    private String rank;
    private String prefix;
    private Boolean isbeta;
}
