package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.mapper.RecordMapper;
import org.example.yansispringboot.pojo.Record;
import org.example.yansispringboot.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 出入库记录服务实现类
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public Record getRecordById(Long id) {
        return recordMapper.selectById(id);
    }

    @Override
    public PageResult<Record> getRecords(int page, int pageSize, Long goodsId, Long warehouseId, Integer type) {
        int offset = (page - 1) * pageSize;
        List<Record> records = recordMapper.selectPage(offset, pageSize, goodsId, warehouseId, type);
        long total = recordMapper.countByCondition(goodsId, warehouseId, type);
        return new PageResult<>(total, records);
    }

    @Override
    public int addRecord(Record record) {
        return recordMapper.insert(record);
    }
}
