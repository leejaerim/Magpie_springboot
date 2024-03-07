package com.jed.mapie.common.response;

import com.jed.mapie.common.exception.EntityNotFoundException;
import com.jed.mapie.common.exception.UnAuthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class CommonControllerAdvice {
    @ExceptionHandler(value = EntityNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse EntityNotFoundException() {
        // String eventId = MDC.get(CommonHttpRequestInterceptor.HEADER_REQUEST_UUID_KEY);
        // log.error("eventId = {} ", eventId, e);
        return CommonResponse.fail(ErrorCode.COMMON_ENTITY_NOT_FOUND);
    }

    @ExceptionHandler(value = UnAuthorizedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public CommonResponse UnAuthorizedException(){
        return CommonResponse.fail(ErrorCode.COMMON_UNAUTHORIZED);
    }
}
