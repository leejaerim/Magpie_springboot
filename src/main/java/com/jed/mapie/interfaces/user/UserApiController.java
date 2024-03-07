package com.jed.mapie.interfaces.user;

import com.jed.mapie.annotation.ChkSession;
import com.jed.mapie.application.user.UserFacade;
import com.jed.mapie.common.exception.LogOutFailException;
import com.jed.mapie.common.response.CommonResponse;
import com.jed.mapie.common.response.ErrorCode;
import com.jed.mapie.common.utils.Constants;
import com.jed.mapie.domain.user.UserCommand;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserApiController {
    private final UserFacade userFacade;
    private final UserDtoMapper userDtoMapper;
    @PostMapping("/api/v1/users")
    public CommonResponse registerUser(@RequestBody @Valid UserDto.RegisterRequest request){
        //DTO.request -> command
        UserCommand.RegisterRequest registerRequest = userDtoMapper.of(request);
        // command to facade -> service -> entity
        var userToken = userFacade.registerUser(registerRequest);
        // return
        return CommonResponse.success(userToken, "OK");
    }

    @GetMapping("/api/v1/users/{userToken}")
    public CommonResponse findByUserToken(@Valid @PathVariable("userToken")String userToken, @ChkSession UserDto.UserLoginInfo userLoginInfo) {
        //facade에게 usertoken을 주고, var Userinfo를 가져옴.
        //return UserInfo
        var userInfo = userFacade.findByUserToken(userToken);
        UserDto.Main main = userDtoMapper.of(userInfo);
        return CommonResponse.success(userInfo);
    }

    @PostMapping("/api/v1/login")
    public CommonResponse login(@RequestBody UserDto.LoginRequest request, HttpSession httpSession) {
        UserCommand.LoginRequest loginRequest = userDtoMapper.of(request);
        var UserInfo = userFacade.login(loginRequest);
        if (httpSession.getAttribute(Constants.AUTH_KEY) != null)
            return CommonResponse.fail(ErrorCode.COMMON_UNAUTHORIZED);
        httpSession.setAttribute(Constants.AUTH_KEY, userDtoMapper.of(UserInfo));
        return CommonResponse.success("OK");
    }
    @GetMapping("/api/v1/logout")
    public CommonResponse logout(HttpSession httpSession) {
        try {
            httpSession.invalidate();
        } catch (IllegalStateException e) {
            throw new LogOutFailException();
        }

        return CommonResponse.success("OK");
    }
}
