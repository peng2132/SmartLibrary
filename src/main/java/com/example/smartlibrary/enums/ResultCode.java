package com.example.smartlibrary.enums;

public enum ResultCode {
    SUCCESS(0),
    FAIL(-1),
    UNLOGIN(-2);
    private int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
