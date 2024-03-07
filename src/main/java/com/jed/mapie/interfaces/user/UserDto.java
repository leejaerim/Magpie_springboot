package com.jed.mapie.interfaces.user;

import com.jed.mapie.domain.user.User;
import com.jed.mapie.domain.user.UserCommand;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

public class UserDto {
    @Getter
    @Setter
    @ToString
    public static class RegisterRequest{
        @NotEmpty(message="userName은 필수 값 입니다.")
        private String userName;
        @NotEmpty(message="email은 필수 값 입니다.")
        private String email;
        // public UserCommand toCommand(){
        //     return UserCommand.builder()
        //             .userName(userName)
        //             .email(email)
        //             .build();
        // }
    }
    @Getter
    @Setter
    @ToString
    public static class LoginRequest{
        @NotEmpty(message = "email은 필수 입니다.")
        private String email;
    }
    @Getter
    @Builder
    @ToString
    public static class Main {
        private final String userName;
        private final String email;
        private final String userToken;
        private final User.SEX sex;
    }
    @Getter
    @Setter
    @Component
    @SessionScope
    @ToString
    public static class UserLoginInfo implements Serializable {
        private String email;
    }
}
