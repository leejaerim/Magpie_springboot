package com.jed.mapie.instructure;

import com.jed.mapie.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserToken(String userToken);

    Optional<User> findByEmail(String email);
}
