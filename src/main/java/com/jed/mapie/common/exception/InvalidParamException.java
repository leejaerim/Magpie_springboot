package com.jed.mapie.common.exception;

import com.jed.mapie.common.response.ErrorCode;

public class InvalidParamException extends BaseException {
    public InvalidParamException(){
        super(ErrorCode.COMMON_INVALID_PARAMETER);
    }
    public InvalidParamException(String message){
        super(ErrorCode.COMMON_INVALID_PARAMETER, message);
    }


}
