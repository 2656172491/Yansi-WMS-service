package org.example.yansispringboot.common;

import lombok.Data;

import java.util.List;

// 分页结果封装
@Data
public class PageResult<T> {
    private long total;
    private List<T> records;

    public PageResult(long total, List<T> records) {
        this.total = total;
        this.records = records;
    }
}
