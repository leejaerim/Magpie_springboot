package com.jed.mapie.instructure;

import com.jed.mapie.common.exception.EntityNotFoundException;
import com.jed.mapie.domain.user.User;
import com.jed.mapie.domain.user.UserCommand;
import com.jed.mapie.domain.user.UserReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserReadImpl implements UserReader {
    private final UserRepository userRepository;
    @Override
    public User findByUserToken(String userToken) {
        return userRepository.findByUserToken(userToken).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User loginUser(UserCommand.LoginRequest request) {
        return userRepository.findByEmail(request.getEmail())
                .orElseThrow(EntityNotFoundException::new);
    }
}
