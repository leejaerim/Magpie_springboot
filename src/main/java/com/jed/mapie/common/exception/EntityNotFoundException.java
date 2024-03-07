package com.jed.mapie.common.exception;

import com.jed.mapie.common.response.ErrorCode;

public class EntityNotFoundException extends BaseException {
    public EntityNotFoundException(){super(ErrorCode.COMMON_INVALID_PARAMETER);}
    public EntityNotFoundException(String message){
        super(ErrorCode.COMMON_INVALID_PARAMETER, message);
    }
}
