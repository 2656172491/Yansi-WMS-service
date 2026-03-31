package org.example.yansispringboot.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    public PageResult<Goods> getAllGoods(Integer pageNum, Integer pageSize) {
        PageResult<Goods> pageResult = new PageResult<>();
        PageHelper.startPage(pageNum, pageSize);

        List<Goods> goodsList = goodsMapper.getAllGoods();
        Page<Goods> page = (Page<Goods>) goodsList;

        pageResult.setTotal(page.getTotal());
        pageResult.setRows(page.getResult());
        pageResult.setPageNum(pageNum);
        pageResult.setPageSize(pageSize);
        return pageResult;
    }
}
