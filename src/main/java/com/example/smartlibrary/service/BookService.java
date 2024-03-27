package com.example.smartlibrary.service;

import com.example.smartlibrary.enums.BookStatusEnum;
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
        //进行转换
        if (bookInfos != null && bookInfos.size()>0){
            for (BookInfo bookInfo : bookInfos) {
                bookInfo.setStatusCN(BookStatusEnum.getNameBycode(bookInfo.getStatus()).getStatusCN());
            }
        }
        return new PageResult<>(bookInfos,count,pageRequest);
    }
}
