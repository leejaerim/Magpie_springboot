package com.jed.mapie.instructure;

import com.jed.mapie.common.exception.InvalidParamException;
import com.jed.mapie.domain.user.User;
import com.jed.mapie.domain.user.UserStore;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {
    private final UserRepository userRepository;
    @Override
    public User save(User user) {
        validation(user);
        return userRepository.save(user);
    }

    private void validation(User user){
        if(StringUtils.isEmpty(user.getUserName())) throw new InvalidParamException("username Exception");
        if(StringUtils.isEmpty(user.getEmail())) throw new InvalidParamException("email Exception");
    }
}
