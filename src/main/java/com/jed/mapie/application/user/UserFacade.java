package com.jed.mapie.application.user;

import com.jed.mapie.domain.user.UserCommand;
import com.jed.mapie.domain.user.UserInfo;
import com.jed.mapie.domain.user.UserService;
import com.jed.mapie.interfaces.user.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserFacade {
    private final UserService userService;
    public String registerUser(UserCommand.RegisterRequest request) {
        var userToken = userService.registerUserInfo(request);
        return userToken;
    }


    public UserInfo.Main findByUserToken(String userToken) {
        return userService.findByUserToken(userToken);
    }

    public UserInfo.UserLoginInfo login(UserCommand.LoginRequest request) {
        return userService.loginUser(request);
    }
}
