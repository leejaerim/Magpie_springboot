package com.jed.mapie.common.response;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private Result result;
    private T data;
    private String message;
    private String errorCode;

    public static <T> CommonResponse<T> success(T data, String message) {
        return (CommonResponse<T>) CommonResponse.builder()
                .result(Result.SUCCESS)
                .data(data)
                .message(message)
                .build();
    }
    public static <T>  CommonResponse<T> success(T data){
        return success(data,null);
    }
    public static <T> CommonResponse<T> fail(T data, String mssage){
        return (CommonResponse<T>) CommonResponse.builder()
                .result(Result.FAIL)
                .message(builder().message)
                .data(data)
                .build();
    }

    public static <T> CommonResponse<T> fail(T data) {
        return fail(data, null);
    }

    public enum Result{
        SUCCESS, FAIL
    }


}
