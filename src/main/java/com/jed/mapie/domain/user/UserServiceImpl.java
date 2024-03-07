package com.jed.mapie.domain.user;

import com.jed.mapie.interfaces.user.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserStore userStore;
    private final UserReader userReader;

    @Override
    @Transactional
    public String registerUserInfo(UserCommand.RegisterRequest request) {
        //request -> initUser ->  user save through store
        User entity = request.toEntity();
        var user = userStore.save(entity);
        return user.getUserToken();
    }

    @Override
    @Transactional
    public UserInfo.Main findByUserToken(String userToken) {
        //get entity
        User user = userReader.findByUserToken(userToken);
        //convert to UserInfo
        return new UserInfo.Main(user);
    }

    @Override
    @Transactional
    public UserInfo.UserLoginInfo loginUser(UserCommand.LoginRequest request) {
        User user = userReader.loginUser(request);
        return new UserInfo.UserLoginInfo(user);
    }

}
