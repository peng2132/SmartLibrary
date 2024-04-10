package com.example.smartlibrary.config;

import com.example.smartlibrary.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ResponseBody
@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler
    public Result exceptionHandler(Exception e) {
       log.error("发生异常,e:", e);
         return Result.fail("系统异常");
    }
    @ExceptionHandler
    public Result exceptionHandler(NullPointerException e) {
        log.error("发生异常,e:", e);
        return Result.fail("空指针异常");
    }
    
}
