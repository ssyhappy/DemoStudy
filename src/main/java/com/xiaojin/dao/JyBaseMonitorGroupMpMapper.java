package com.xiaojin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaojin.domain.JyBaseMonitor;
import com.xiaojin.domain.JyBaseMonitorGroupMp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sushaoyou
 * @since 2023-09-18
 */
public interface JyBaseMonitorGroupMpMapper extends BaseMapper<JyBaseMonitorGroupMp> {
    List<JyBaseMonitor> selectToMonitorByMp(@Param("groupId") Integer groupId);
}
