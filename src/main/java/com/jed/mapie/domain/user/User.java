package com.jed.mapie.domain.user;

import com.jed.mapie.common.utils.TokenGenerator;
import com.jed.mapie.domain.AbstractEntity;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.security.InvalidParameterException;

@Entity
@Slf4j
@Getter
@NoArgsConstructor
@Table(name="users")
public class User extends AbstractEntity {
    private static final String PREFIX_USER = "user_";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userToken;
    private String userName;
    @Enumerated(EnumType.STRING)
    private SEX sex;
    private String email;
    @Getter
    @RequiredArgsConstructor
    public enum SEX{
        NOTCHOOSE("선택안함"),MALE("남"), FEMALE("여");
        private final String description;
    }
    @Builder
    public User(String userName, String email){
        if(StringUtils.isEmpty(userName)) throw new InvalidParameterException("empty userName");
        if(StringUtils.isEmpty(email)) throw new InvalidParameterException("empty userName");

        this.email = email;
        this.userToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_USER);
        this.userName = userName;
        this.sex = SEX.NOTCHOOSE;
    }

}
