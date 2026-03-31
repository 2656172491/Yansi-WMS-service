package org.example.yansispringboot.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.mapper.GoodsMapper;
import org.example.yansispringboot.mapper.InventoryMapper;
import org.example.yansispringboot.mapper.RecordMapper;
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
        long goodsId = record.getGoodsId();
        long warehouseId = record.getWarehouseId();
        Inventory inventory = InventoryMapper.getByIdInventory(goodsId,warehouseId);
        int nowQuantity = inventory.getQuantity();
        record.setBeforeQuantity(nowQuantity);
        if (record.getType() == 1) {
            // 入库
            inventory.setQuantity(nowQuantity + record.getQuantity());
        } else if (record.getType() == 2) {
            // 出库
            inventory.setQuantity(nowQuantity - record.getQuantity());
        }
        record.setOperator(username);
        recordMapper.insertRecord(record);
    }
}
