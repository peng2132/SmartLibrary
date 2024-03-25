package com.example.smartlibrary.model;

import lombok.Data;


@Data
public class PageRequest {
//      当前页码
    private Integer currentPage=1;
//      每页显示条数
    private Integer pageSize=10;

    private Integer offset;

    public Integer getOffset() {
        return (currentPage-1) * pageSize;
    }
}