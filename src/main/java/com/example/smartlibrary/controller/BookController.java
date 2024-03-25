package com.example.smartlibrary.controller;

import com.example.smartlibrary.model.BookInfo;
import com.example.smartlibrary.model.PageRequest;
import com.example.smartlibrary.model.PageResult;
import com.example.smartlibrary.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/book")
@RestController
@Slf4j
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("getBookListByPage")
    public PageResult<BookInfo> getBookListByPage(PageRequest pageRequest) {
        log.info("查询翻页信息,pageRequest:{}",pageRequest);
        if(pageRequest.getPageSize()<0||pageRequest.getCurrentPage()<1){
            return null;
        }
        PageResult<BookInfo> bookInfoPageResult = null;
        try{
            bookInfoPageResult =  bookService.getBookListByPage(pageRequest);
        }catch (Exception e){
            log.error("查询翻页信息错误,e{}",e);
        }
        return bookInfoPageResult;
    }
}
