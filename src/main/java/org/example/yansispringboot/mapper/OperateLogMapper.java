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

    @Insert("insert into operate_log(user_id,username,type,module,content,ip) " +
            "values(#{userId},#{username},#{type},#{module},#{content},#{ip})")
    void addLog(OperateLog operateLog);

    @Select("select id,username,content,create_time from operate_log where type = 'set'")
    List<Map<String, Object>> getRecentActivities();
}
