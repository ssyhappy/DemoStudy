package com.xiaojin.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiaojin.dao.JyBaseMonitorGroupMpMapper;
import com.xiaojin.dao.JyBaseMonitorMapper;
import com.xiaojin.domain.JyBaseMonitor;
import com.xiaojin.domain.JyBaseMonitorGroupMp;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sushaoyou
 * @since 2023-09-14
 */
@RestController
@RequestMapping("/monitorGroup")
public class JyBaseMonitorGroupMpController {
    @Resource
    private JyBaseMonitorGroupMpMapper jyBaseMonitorGroupMpMapper;
    @Resource
    private JyBaseMonitorMapper jyBaseMonitorMapper;

    @GetMapping("selectMonitorByMp")
    public List<JyBaseMonitor> selectMonitorByMp(@RequestParam("groupId") Integer groupId) throws Exception {
        //先通过groupId查询jy_base_monitor_group_mp表中的数据
        List<JyBaseMonitorGroupMp> list = jyBaseMonitorGroupMpMapper.selectList(Wrappers.<JyBaseMonitorGroupMp>lambdaQuery().eq(JyBaseMonitorGroupMp::getGroupId, groupId));
        //查询到数据库后你需要拿到JyBaseMonitorGroupMp对象中所有groupId下的所有监测点Id 需要遍历后加监测点id加入到新的集合中
        //表中有的groupId查询不到数据 所有要对集合判空 否则会报空指针异常
        if (CollectionUtils.isEmpty(list)) {
            throw new Exception("根据groupId查询不到数据,请输入正确的groupId");
        }
        List<Long> monitorIdList = new ArrayList<>();
        //forEach遍历后添加到新的集合中 此时monitorIdList就有所有groupId下的监测点Id
        list.forEach(t -> {
            monitorIdList.add(t.getMonitorId());
        });
        //有了监测点集合去批量查询监测点信息
        //这里是根据Id批量查询selectBatchIds这个方法
//        List<JyBaseMonitor> jyBaseMonitorList = jyBaseMonitorMapper.selectBatchIds(monitorIdList);
//        return jyBaseMonitorList;
        return jyBaseMonitorMapper.selectBatchIds(monitorIdList);

    }
    @GetMapping("selectMonitorByMp2")
    public List<JyBaseMonitor> selectMonitorByMp2(@RequestParam("groupId") Integer groupId){
        return (CollectionUtils.isEmpty(jyBaseMonitorGroupMpMapper.selectToMonitorByMp(groupId))?null:jyBaseMonitorGroupMpMapper.selectToMonitorByMp(groupId));
    }


}
