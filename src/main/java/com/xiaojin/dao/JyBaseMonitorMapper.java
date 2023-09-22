package com.xiaojin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaojin.domain.JyBaseMonitor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JyBaseMonitorMapper extends BaseMapper<JyBaseMonitor> {
    List<JyBaseMonitor> selectToMonitor(@Param("dataType") String dataType,@Param("monitorCode") String monitorCode);

}
