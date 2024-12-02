package com.alkaid.API.base.module.body;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {
    private T data;
    private String message;
    private boolean status;
}
