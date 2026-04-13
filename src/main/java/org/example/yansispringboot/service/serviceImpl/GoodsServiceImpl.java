package org.example.yansispringboot.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.mapper.GoodsMapper;
import org.example.yansispringboot.mapper.InventoryMapper;
import org.example.yansispringboot.mapper.RecordMapper;
import org.example.yansispringboot.mapper.UserMapper;
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

    @Autowired
    private InventoryMapper InventoryMapper;

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageResult<Goods> getAllGoods(Integer pageNum, Integer pageSize, String name, String code, String categoryId, String status) {
        PageResult<Goods> pageResult = new PageResult<>();
        PageHelper.startPage(pageNum, pageSize);

        List<Goods> goodsList = goodsMapper.getAllGoods(name,code,categoryId,status);
        Page<Goods> page = (Page<Goods>) goodsList;

        pageResult.setTotal(page.getTotal());
        pageResult.setRows(page.getResult());
        pageResult.setPageNum(pageNum);
        pageResult.setPageSize(pageSize);
        return pageResult;
    }

    @Override
    public Goods getGoodById(String id) {
        return goodsMapper.getGoodById(id);
    }

    @Override
    public void deleteGoods(String id) {
        goodsMapper.deleteGood(id);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsMapper.updateGood(goods);
    }

    @Override
    public void addGoods(Goods goods) {
        goodsMapper.addGoods(goods);
    }
}
