package com.jed.mapie.common.exception;

import com.jed.mapie.common.response.ErrorCode;

public class BaseException extends RuntimeException{
    private ErrorCode errorCode;
    public BaseException(){}
    public BaseException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }
    public BaseException(ErrorCode errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }
    public BaseException(ErrorCode errorCode, String msg, Throwable casuse) {
        super(msg, casuse);
        this.errorCode = errorCode;
    }
}
