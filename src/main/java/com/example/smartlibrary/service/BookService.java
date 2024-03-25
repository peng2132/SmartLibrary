package com.example.smartlibrary.service;

import com.example.smartlibrary.mapper.BookInfoMapper;
import com.example.smartlibrary.model.BookInfo;
import com.example.smartlibrary.model.PageRequest;
import com.example.smartlibrary.model.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookInfoMapper bookInfoMapper;
    public PageResult<BookInfo> getBookListByPage(PageRequest pageRequest) {
        //获取总记录数
        Integer count = bookInfoMapper.count();
        //获取当前记录
        List<BookInfo> bookInfos = bookInfoMapper.selectBookListByPage((pageRequest.getOffset()),pageRequest.getPageSize());

        return new PageResult<>(bookInfos,count,pageRequest);
    }
}
