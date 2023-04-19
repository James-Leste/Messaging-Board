package com.example.ForumServer.Exceptions;

import com.example.ForumServer.Common.Constants;
import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {
    private String code;

    public ServiceException(){}

    public ServiceException(String code, String message){
        super(message);
        this.code = code;
    }
}
