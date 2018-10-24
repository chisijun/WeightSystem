package org.chisj.weight.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.chisj.weight.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2018-10-17 09:50
 * @Description:
 */
@Component("fallback")
@Slf4j
public class UserServiceFailImpl implements UserService {

    @Override
    public String login(String name) {
        log.error("restTemplate调用[hello]服务发生熔断，参数name:{}", name);
        return "restTemplate调用[hello]服务发生熔断，参数name:" + name;
    }
}
