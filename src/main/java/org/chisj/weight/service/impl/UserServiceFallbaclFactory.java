package org.chisj.weight.service.impl;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.chisj.weight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2018-10-17 09:47
 * @Description:
 */
@Component
@Slf4j
public class UserServiceFallbaclFactory implements FallbackFactory<UserService> {

    @Autowired
    @Qualifier("fallback")
    UserService userService;

    @Override
    public UserService create(Throwable cause) {
        log.error("feign调用发生异常，触发熔断", cause);
        return userService;
    }
}
