package com.jed.mapie.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Builder
public class UserCommand {

    @Getter
    @Builder
    @ToString
    public static class RegisterRequest{
        private String userName;
        private String email;

        public User toEntity(){
            return User.builder()
                    .userName(userName)
                    .email(email)
                    .build();
        }
    }
    @Getter
    @Builder
    @ToString
    public static class LoginRequest{
        private String email;
    }
}
