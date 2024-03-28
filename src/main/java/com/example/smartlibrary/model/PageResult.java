package com.example.smartlibrary.model;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    //当前页的记录
    private List<T> records;
    //总记录数
    private Integer total;



    private PageRequest pageRequest;

    public PageResult(List<T> records, Integer total,PageRequest pageRequest) {
        this.records = records;
        this.total = total;
        this.pageRequest = pageRequest;
    }
}