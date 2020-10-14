package com.kctv.api.model.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResult<T> extends CommonResult{

    private String token;
    private T user;


}
