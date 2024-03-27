package com.example.smartlibrary.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class BookInfo {
    private int id;
    private String bookName;
    private String author;
    private int count;
    private BigDecimal price;
    private String publish;
    private Byte status;  //0 删除，1 可借阅，2 不可借阅
    private String statusCN;
    private Date createTime;
    private Date updateTime;
}
