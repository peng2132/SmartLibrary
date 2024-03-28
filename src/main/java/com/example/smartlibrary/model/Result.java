package com.example.smartlibrary.model;

import com.example.smartlibrary.enums.ResultCode;
import lombok.Data;

@Data
public class Result {
    //业务状态码
    private ResultCode code; // 例如：0 成功  -1 失败  -2 未登录
    //错误信息
    private String errMsg;
    //数据
    private Object data;

    public static Result success (Object data) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setErrMsg("");
        result.setData(data);
        return result;
    }
    public static Result fail (String errMsg,Object data) {
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setErrMsg("");
        result.setErrMsg(errMsg);
        result.setData(data);
        return result;
    }
    public static Result unlogin () {
        Result result = new Result();
        result.setCode(ResultCode.UNLOGIN);
        result.setErrMsg("");
        result.setData(null);
        return result;
    }

}
