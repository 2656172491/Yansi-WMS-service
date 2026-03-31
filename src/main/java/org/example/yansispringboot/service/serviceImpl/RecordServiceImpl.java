package org.example.yansispringboot.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    public PageResult<Record> getAllRecords(Integer pageNum, Integer pageSize, Integer type) {
        PageResult<Record> pageResult = new PageResult<>();
        PageHelper.startPage(pageNum, pageSize);

        List<Record> recordList = recordMapper.getAllRecords(type);
        Page<Record> page = (Page<Record>) recordList;

        pageResult.setTotal(page.getTotal());
        pageResult.setRows(page.getResult());
        pageResult.setPageNum(pageNum);
        pageResult.setPageSize(pageSize);
        return pageResult;
    }
}
