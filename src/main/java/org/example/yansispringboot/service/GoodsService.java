package org.example.yansispringboot.service;

import org.example.yansispringboot.common.PageResult;

// 物资服务接口
public interface GoodsService {

    PageResult getAllGoods(Integer pageNum, Integer pageSize);
}
