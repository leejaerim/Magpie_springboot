package com.jed.mapie.domain.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
public class UserInfo {
    private String userToken;
    private String userName;
    private User.SEX sex;
    private String email;

    public UserInfo(User user) {
        this.userToken = user.getUserToken();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.sex = user.getSex();
    }
    @Getter
    @ToString
    public static class Main {
        private String userName;
        private String email;
        private String userToken;
        private User.SEX sex;

        public Main(User user) {
            this.userName = user.getUserName();
            this.sex = user.getSex();
            this.userToken = user.getUserToken();
            this.email = user.getEmail();
        }
    }
    @Getter
    @ToString
    public static class UserLoginInfo implements Serializable {
        private String email;
        public UserLoginInfo(User user){
            this.email = user.getEmail();
        }
    }
}
