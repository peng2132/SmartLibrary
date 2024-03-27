package com.example.smartlibrary.enums;

public enum BookStatusEnum {
    DELETE((byte)0,"已删除"),
    NORMAL((byte)1,"可借阅"),
    FORBIDDEN((byte)2,"不可借阅");

    private Byte code;
    private String statusCN;

    public static BookStatusEnum getNameBycode(Byte code){
        switch (code){
            case 0:
                return BookStatusEnum.DELETE;
            case 1:
                return BookStatusEnum.NORMAL;
            case 2:
                return BookStatusEnum.FORBIDDEN;
            default:
                return null;
        }
    }
    BookStatusEnum(Byte code, String statusCN) {
        this.code = code;
        this.statusCN = statusCN;
    }
    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }

    public String getStatusCN() {
        return statusCN;
    }

    public void setStatusCN(String statusCN) {
        this.statusCN = statusCN;
    }
}
