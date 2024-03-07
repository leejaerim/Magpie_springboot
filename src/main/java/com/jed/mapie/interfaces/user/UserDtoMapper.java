package com.jed.mapie.interfaces.user;

import com.jed.mapie.domain.user.UserCommand;
import com.jed.mapie.domain.user.UserInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UserDtoMapper {
    UserCommand.RegisterRequest of(UserDto.RegisterRequest request);

    UserCommand.LoginRequest of(UserDto.LoginRequest request);

    UserDto.Main of(UserInfo.Main main);

    UserDto.UserLoginInfo of(UserInfo.UserLoginInfo userLoginInfo);

}
