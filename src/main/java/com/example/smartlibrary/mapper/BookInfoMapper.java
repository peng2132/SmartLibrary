package com.example.smartlibrary.mapper;

import com.example.smartlibrary.model.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookInfoMapper {
    //获取当前页信息
    @Select("select * from book_info where status != 0" +
            " order by id desc limit #{offset},#{pageSize}")
    List<BookInfo> selectBookListByPage(@Param("offset") Integer offset,@Param("pageSize") Integer pageSize);
    //获取总记录数
    @Select("select count(1) from book_info where status != 0")
    Integer count();
}
