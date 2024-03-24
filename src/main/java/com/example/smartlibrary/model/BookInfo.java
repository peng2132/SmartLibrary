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
    private Byte status;
    private Date createTime;
    private Date updateTime;
}
