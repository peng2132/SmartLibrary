package com.example.smartlibrary.interceptor;

import com.example.smartlibrary.constant.Constants;
import com.example.smartlibrary.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入拦截器");
        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute(Constants.SESSION_USER_KEY) != null){
            UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
            if(userInfo != null && userInfo.getId() > 0){
                return true;
            }
        }
        response.setStatus(401);//未认证登录
        return false;
    }
}
