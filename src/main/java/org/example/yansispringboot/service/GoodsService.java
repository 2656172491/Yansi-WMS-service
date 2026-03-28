package org.example.yansispringboot.service;

import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.pojo.Goods;

// 物资服务接口
public interface GoodsService {

    Goods getGoodsById(Long id);

    PageResult<Goods> getGoods(int page, int pageSize, String name, Long categoryId);

    int addGoods(Goods goods);

    int updateGoods(Goods goods);

    int deleteGoods(Long id);
}
