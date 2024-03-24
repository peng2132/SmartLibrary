package com.example.smartlibrary.controller;


import com.example.smartlibrary.model.UserInfo;
import com.example.smartlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public Boolean login(String username, String password, HttpSession session) {
        //校验参数
        if(!StringUtils.hasLength(username) || !StringUtils.hasLength(password)){
            return false;
        }
        UserInfo userInfo = userService.getUserInfoByName(username);
        if(userInfo == null || userInfo.getId()<0){
            return false;
        }
        if(password.equals(userInfo.getPassword())){
            userInfo.setPassword(null);
            session.setAttribute("userName", userInfo);
            return true;
        }
        return false;
    }

}
