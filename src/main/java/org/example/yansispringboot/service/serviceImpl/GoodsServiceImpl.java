package org.example.yansispringboot.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.mapper.GoodsMapper;
import org.example.yansispringboot.mapper.InventoryMapper;
import org.example.yansispringboot.mapper.RecordMapper;
import org.example.yansispringboot.mapper.UserMapper;
import org.example.yansispringboot.pojo.Goods;
import org.example.yansispringboot.pojo.Inventory;
import org.example.yansispringboot.pojo.Record;
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

    @Override
    public void updateGoods(Integer id, Record record, String username) {
        // 获取商品id和仓库id
        long goodsId = record.getGoodsId();
        long warehouseId = record.getWarehouseId();
        // 根据商品id和仓库id获取当前库存数量
        Inventory inventory = InventoryMapper.getByIdInventory(goodsId,warehouseId);
        // 获取当前库存数量，并根据操作类型更新库存数量
        int nowQuantity = inventory.getQuantity();
        // 设置操作前的库存数量
        record.setBeforeQuantity(nowQuantity);

        // 更新库存数量
        if (record.getType() == 1) {
            // 入库
            inventory.setQuantity(nowQuantity + record.getQuantity());
        } else if (record.getType() == 2) {
            // 出库
            inventory.setQuantity(nowQuantity - record.getQuantity());
        }
        // 更新库存信息
        InventoryMapper.updateInventory(goodsId, warehouseId, inventory.getQuantity());
        // 设置变更后数量
        record.setAfterQuantity(inventory.getQuantity());
        // 设置操作人信息
        record.setOperatorId(userMapper.getUserByName(username).getId());
        record.setOperatorName(username);
        recordMapper.insertRecord(record);
    }

    @Override
    public Goods getGoodById(String id) {
        return goodsMapper.getGoodById(id);
    }
}
