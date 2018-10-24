package org.chisj.weight.service;

import feign.Param;
import org.chisj.weight.service.impl.UserServiceFallbaclFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2018-10-16 20:53
 * @Description:
 */
@FeignClient(name="nursingCloudCmnyClient",/*fallback=HelloClientFailImpl.class,*/
        fallbackFactory = UserServiceFallbaclFactory.class)
public interface UserService {

    /**
     * 登录
     */
    @RequestMapping(value = "/NursingCloudCmny/user/login", method = RequestMethod.POST)
    public String login(@RequestParam("name") String name);
}
