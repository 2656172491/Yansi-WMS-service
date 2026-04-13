package org.example.yansispringboot.service;

import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.pojo.Goods;

// 物资服务接口
public interface GoodsService {

    PageResult getAllGoods(Integer pageNum, Integer pageSize, String name, String code, String categoryId, String status);

    Goods getGoodById(String id);

    void deleteGoods(String id);

    void updateGoods(Goods goods);

    void addGoods(Goods goods);
}
