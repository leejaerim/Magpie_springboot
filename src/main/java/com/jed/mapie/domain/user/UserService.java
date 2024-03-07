package com.jed.mapie.domain.user;

import com.jed.mapie.interfaces.user.UserDto;

import java.util.List;

public interface UserService {
    // List<UserInfo> getUsersInfo(UserCommand userCommand);

    String registerUserInfo(UserCommand.RegisterRequest request);

    UserInfo.Main findByUserToken(String userToken);

    UserInfo.UserLoginInfo loginUser(UserCommand.LoginRequest request);

}
