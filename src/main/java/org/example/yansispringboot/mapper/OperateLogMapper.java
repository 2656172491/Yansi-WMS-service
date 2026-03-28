package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.yansispringboot.pojo.OperateLog;


// 操作日志数据访问层
@Mapper
public interface OperateLogMapper {

    @Insert("insert into operatelog (username, type, module, content, ip, createTime) " +
            "values (#{username}, #{type}, #{module}, #{content}, #{ip}, now())")
    void addLog(OperateLog operateLog);
}
