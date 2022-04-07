package com.financial.analysis.service.user.impl;

public class CustomUserException extends RuntimeException{

    public CustomUserException(){

    }

    public CustomUserException(String msg){
        super(msg);
    }

}
