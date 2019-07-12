package com.doudh.exception;


import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpStatus;

/**
 * @auth doudh
 * @time 2019-7-8
 */
@Setter
@Getter
public class TokenException extends RuntimeException {

    private String msg;
    private int code;

    public TokenException(String msg) {
        this.msg = msg;
        this.code = HttpStatus.SC_UNAUTHORIZED;
    }

}
