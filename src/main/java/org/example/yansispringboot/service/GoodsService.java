package org.example.yansispringboot.service;

import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.pojo.Goods;
import org.example.yansispringboot.pojo.Record;

// 物资服务接口
public interface GoodsService {

    PageResult getAllGoods(Integer pageNum, Integer pageSize);

    void updateGoods(Integer id, Record record, String username);

    Goods getGoodById(String id);
}
