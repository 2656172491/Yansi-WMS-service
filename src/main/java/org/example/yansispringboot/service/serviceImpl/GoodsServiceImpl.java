package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.mapper.GoodsMapper;
import org.example.yansispringboot.pojo.Goods;
import org.example.yansispringboot.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 物资服务实现类
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods getGoodsById(Long id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public PageResult<Goods> getGoods(int page, int pageSize, String name, Long categoryId) {
        int offset = (page - 1) * pageSize;
        List<Goods> records = goodsMapper.selectPage(offset, pageSize, name, categoryId);
        long total = goodsMapper.countByCondition(name, categoryId);
        return new PageResult<>(total, records);
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.update(goods);
    }

    @Override
    public int deleteGoods(Long id) {
        return goodsMapper.deleteById(id);
    }
}
