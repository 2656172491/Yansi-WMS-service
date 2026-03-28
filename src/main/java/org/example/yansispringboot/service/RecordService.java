package org.example.yansispringboot.service;

import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.pojo.Record;

// 出入库记录服务接口
public interface RecordService {

    Record getRecordById(Long id);

    PageResult<Record> getRecords(int page, int pageSize, Long goodsId, Long warehouseId, Integer type);

    int addRecord(Record record);
}
