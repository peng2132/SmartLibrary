package com.example.smartlibrary.service;

import com.example.smartlibrary.enums.BookStatusEnum;
import com.example.smartlibrary.mapper.BookInfoMapper;
import com.example.smartlibrary.model.BookInfo;
import com.example.smartlibrary.model.PageRequest;
import com.example.smartlibrary.model.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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
    //新增图书信息
    public Integer addBook(BookInfo bookInfo) {
        Integer result = 0;
        try{
           result = bookInfoMapper.insertBook(bookInfo);
            if (result <= 0){
                log.error("新增图书信息失败,bookInfo:{}",bookInfo);
            }
        }catch (Exception e){
            log.error("新增图书信息错误,e{}",e);
        }
        return result;
    }
    public BookInfo queryBookInfoById(Integer id) {
        return bookInfoMapper.selectBookById(id);
    }
    public Integer updateBook(BookInfo bookInfo) {
        return bookInfoMapper.updateBook(bookInfo);
    }
}
