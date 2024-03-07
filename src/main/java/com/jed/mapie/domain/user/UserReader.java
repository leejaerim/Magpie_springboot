package com.jed.mapie.domain.user;

public interface UserReader {
    User findByUserToken(String userToken);

    User loginUser(UserCommand.LoginRequest request);
}
