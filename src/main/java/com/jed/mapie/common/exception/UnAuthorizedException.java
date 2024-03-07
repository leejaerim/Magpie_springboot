package com.jed.mapie.common.exception;

import com.jed.mapie.common.response.ErrorCode;

public class UnAuthorizedException extends BaseException{
    public UnAuthorizedException(){
        super(ErrorCode.COMMON_UNAUTHORIZED);
    }
    public UnAuthorizedException(String message){
        super(ErrorCode.COMMON_UNAUTHORIZED, message);
    }
}
