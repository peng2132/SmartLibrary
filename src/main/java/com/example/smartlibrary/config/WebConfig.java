package com.example.smartlibrary.config;

import com.example.smartlibrary.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    private static List<String> excludePath = Arrays.asList("/user/login",
            "/css/**",
            "/js/**",
            "/pic/**",
            "/**/*.html",
            "/test/**");

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")            //表示给所有方法添加拦截器
                .excludePathPatterns(excludePath); //表示排除拦截的路径
    }
}
