package com.jed.mapie.config.resolver;

import com.jed.mapie.annotation.ChkSession;
import com.jed.mapie.common.utils.Constants;
import com.jed.mapie.interfaces.user.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class AuthUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean hasSessionAuthAnnotation = parameter.hasParameterAnnotation(ChkSession.class);
        boolean hasAuthUserType = UserDto.UserLoginInfo.class.isAssignableFrom(parameter.getParameterType());
        return hasSessionAuthAnnotation && hasAuthUserType;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest)webRequest.getNativeRequest();
        HttpSession session = httpServletRequest.getSession(false);
        return session.getAttribute(Constants.AUTH_KEY);
    }
}
