package com.example.smartlibrary.model;

import com.example.smartlibrary.enums.ResultCode;
import lombok.Data;

@Data
public class Result<T> {
    /**
     * 业务状态码
     */
    private ResultCode code;  //0-成功  -1 失败  -2 未登录
    /**
     * 错误信息
     */
    private String errMsg;
    /**
     * 数据
     */
    private T data;

    public static <T> Result<T> success(T data){
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setErrMsg("");
        result.setData(data);
        return result;
    }
    public static <T> Result<T> fail(String errMsg){
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setErrMsg(errMsg);
        result.setData(null);
        return result;
    }
    public static <T> Result<T> fail(String errMsg,Object data){
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setErrMsg(errMsg);
        result.setData(data);
        return result;
    }
    public static <T> Result<T> unlogin(){
        Result result = new Result();
        result.setCode(ResultCode.UNLOGIN);
        result.setErrMsg("用户未登录");
        result.setData(null);
        return result;
    }

}