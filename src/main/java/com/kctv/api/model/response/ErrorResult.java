package com.kctv.api.model.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResult {
    private String message;
    private Object object;

}
