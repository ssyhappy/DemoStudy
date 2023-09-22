package com.xiaojin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaojin.domain.JyDataElec0012020;
import com.xiaojin.req.MonitorReq;
import com.xiaojin.req.MonthToReq2;
import com.xiaojin.rsp.MonitorRsp;
import com.xiaojin.rsp.MonthRsp;
import com.xiaojin.rsp.MonthRsp2;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sushaoyou
 * @since 2023-04-12
 */
@Repository
public interface JyDataElec0012020Mapper extends BaseMapper<JyDataElec0012020> {
    MonitorRsp selectByXml(MonitorReq monitorReq);
    List<MonthRsp2> selectByXmlMonth(MonthToReq2 monthToReq2);
}
