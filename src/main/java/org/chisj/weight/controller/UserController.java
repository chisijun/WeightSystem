package org.chisj.weight.controller;

import lombok.extern.slf4j.Slf4j;
import org.chisj.weight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2018-10-12 10:44
 * @Description: 用户管理控制器
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Value("${config}")
    String config;

//    @Autowired
//    LoadBalancerClient loadBalancerClient;

//    @Autowired
//    RestTemplate restTemplate;

    // 使用@FeignClien注解定义接口
//    @Autowired
//    UserService userService;



    @GetMapping("/config")
    public String config() {
        return "返回的config参数值为:" + config;
    }

//    @GetMapping("/login")
//    public String login(String name) {
//        log.info("name = " + name);
//        ServiceInstance serviceInstance = loadBalancerClient.choose("nursingCloudCmnyClient");
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort()
//                + "/NursingCloudCmny/user/login?name=" + name;
//        log.info("url地址为：{}", url);
//        return restTemplate.postForObject(url, null, String.class);
////        return restTemplate.getForObject(url, String.class);
////        return name;
//    }

//        @GetMapping("/login")
//        public String login(String name) {
//            String result = userService.login(name);
//            log.info("result: {}", result);
//            return result;
//            String url = "http://nursingCloudCmnyClient/NursingCloudCmny/user/login";
//            log.info("name = " + name);
//            ServiceInstance serviceInstance = loadBalancerClient.choose("nursing cloud cmny client");
//            String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort()
//                + "/NursingCloudCmny/user/login?name=" + name;
//            log.info("url地址为：{}", url);

//            String result = restTemplate.postForObject(url, null, String.class);
//            log.info("result: {}", result);
//            return result;
//            return restTemplate.getForObject(url, String.class);
//            return name;
//        }

}
