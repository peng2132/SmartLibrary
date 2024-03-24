package com.example.smartlibrary.mapper;

import com.example.smartlibrary.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
    @Select("select * from user_info where user_name = #{userName}")
    UserInfo selectUserInfoByName(String userName);
}
