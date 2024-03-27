package com.example.smartlibrary.mapper;

import com.example.smartlibrary.model.BookInfo;
import org.apache.ibatis.annotations.Insert;
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

    //新增图书信息
    @Insert("insert into book_info(book_name,author,count,price,publish,status) " +
            "values(#{bookName},#{author},#{count},#{price},#{publish},#{status})")
    Integer insertBook(BookInfo bookInfo);
}
