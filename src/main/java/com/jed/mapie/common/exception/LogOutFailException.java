package com.jed.mapie.common.exception;

import com.jed.mapie.common.response.ErrorCode;

public class LogOutFailException extends BaseException{
    public LogOutFailException(){
        super(ErrorCode.ALREADY_LOGOUT);}
    public LogOutFailException(String message){
        super(ErrorCode.ALREADY_LOGOUT,message);
    }
}
