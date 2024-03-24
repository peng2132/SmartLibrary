package com.example.smartlibrary.service;

import com.example.smartlibrary.mapper.UserInfoMapper;
import com.example.smartlibrary.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public UserInfo getUserInfoByName(String userName) {
        return userInfoMapper.selectUserInfoByName(userName);
    }
}
