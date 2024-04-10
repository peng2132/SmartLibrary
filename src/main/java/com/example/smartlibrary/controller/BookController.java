package com.example.smartlibrary.controller;

import com.example.smartlibrary.constant.Constants;
import com.example.smartlibrary.enums.ResultCode;
import com.example.smartlibrary.model.*;
import com.example.smartlibrary.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/book")
@RestController
@Slf4j
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("getBookListByPage")
    public Result getBookListByPage(PageRequest pageRequest, HttpSession session) {
        log.info("查询翻页信息,pageRequest:{}",pageRequest);
        //用户登录校验
//        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
//        if(userInfo == null || userInfo.getId()<=0){
//            return Result.unlogin();
//        }

        //校验成功
        if(pageRequest.getPageSize()<0||pageRequest.getCurrentPage()<1){
            return null;
        }
        PageResult<BookInfo> bookInfoPageResult = null;
        try{
            bookInfoPageResult =  bookService.getBookListByPage(pageRequest);
            return Result.success(bookInfoPageResult);
        }catch (Exception e){
            log.error("查询翻页信息错误,e{}",e);
        }
        return Result.fail("查询失败",bookInfoPageResult);
    }
    @RequestMapping(value = "addBook",produces = "application/json;charset=UTF-8" )
    public String addBook(BookInfo bookInfo){
        log.info("新增图书信息,bookInfo:{}",bookInfo);
        //参数校验
        if(!StringUtils.hasLength(bookInfo.getBookName()) ||
                !StringUtils.hasLength(bookInfo.getAuthor()) ||
                bookInfo.getCount()<=0 ||
                bookInfo.getPrice() == null ||
                !StringUtils.hasLength(bookInfo.getPublish())){
            return "参数错误";
        }
        Integer result = bookService.addBook(bookInfo);
        if(result <= 0){
            log.error("新增图书信息失败,bookInfo:{}",bookInfo);
            return "添加失败，请联系管理员";
        }
        return "";
    }
    @RequestMapping("queryBookInfoById")
    public BookInfo queryBookInfoById(Integer bookId){
        log.info("查询图书信息,id:{}",bookId);
        try{
            BookInfo bookInfo = bookService.queryBookInfoById(bookId);
            return bookInfo;
        }
        catch (Exception e){
            log.error("查询图书信息错误,e{}",e);
        }
       return null;
    }
    @RequestMapping(value = "updateBook",produces = "application/json;charset=UTF-8")

    public String updateBook(BookInfo bookInfo){
        log.info("接收到更新图书的请求, bookInfo:{}",bookInfo);
        Integer result = bookService.updateBook(bookInfo);
        if (result == 0){
            log.error("更新图书失败, 请联系管理员");
            return "更新图书失败, 请联系管理员";
        }
        return "";
    }
    //设置返回为json格式
    @RequestMapping(value = "batchDelete",produces = "application/json;charset=UTF-8")
    public String batchDelete(@RequestParam List<Integer> ids){
        log.info("批量删除图书信息,ids:{}",ids);
        Integer result = bookService.batchDelete(ids);
        if(result <= 0){
            log.error("批量删除图书信息失败,ids:{}",ids);
            return "删除失败，请联系管理员";
        }
        return "";
    }

}
