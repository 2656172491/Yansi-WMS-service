package org.example.yansispringboot.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// 分页结果封装
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Long total;         // 总记录数
    private List<T> rows;       // 当前页数据
    private Integer pageNum;    // 当前页码
    private Integer pageSize;   // 每页记录数
}
