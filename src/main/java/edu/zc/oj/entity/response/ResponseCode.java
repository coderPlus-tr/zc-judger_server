package edu.zc.oj.entity.response;

import lombok.Data;

/**
 * @author coderPlus-tr
 */

public enum ResponseCode {
    /**
     *
     */

    SUCCESS(200, "ok"),
    PARAMS_ERROR(100, "params error"),
    NOT_FOUND(404, "not found"),
    SERVER_ERROR(500, "server error")
    ;
    private final Integer code;
    private final String message;
    ResponseCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    public  Integer getCode(){ return code; }
    public String getMessage(){ return message; }
}
