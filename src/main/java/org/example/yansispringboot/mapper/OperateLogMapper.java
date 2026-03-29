package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.yansispringboot.pojo.OperateLog;

import java.util.List;
import java.util.Map;


// 操作日志数据访问层
@Mapper
public interface OperateLogMapper {

    @Insert("insert into operatelog (username, type, module, content, ip, create_time) " +
            "values (#{username}, #{type}, #{module}, #{content}, #{ip}, now())")
    void addLog(OperateLog operateLog);

    @Select("select id,username,content,create_time from operatelog where type = 'set'")
    List<Map<String, Object>> getRecentActivities();
}
