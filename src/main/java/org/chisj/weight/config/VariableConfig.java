package org.chisj.weight.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2018-10-12 13:25
 * @Description: 变量配置类
 */
@Component
@ConfigurationProperties(prefix="variable")
@PropertySource("classpath:config/variable.properties")
public class VariableConfig {

    private float height;

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "VariableConfig{" +
                "height=" + height +
                '}';
    }
}
