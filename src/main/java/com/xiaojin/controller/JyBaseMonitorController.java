package com.xiaojin.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiaojin.dao.JyBaseMonitorMapper;
import com.xiaojin.domain.JyBaseMonitor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/monitor")
public class JyBaseMonitorController {
    @Autowired
    private JyBaseMonitorMapper jyBaseMonitorMapper;

    @GetMapping("selectByMonitor1")
    public List<JyBaseMonitor> selectByMonitor1(@RequestParam(name = "dataType", required = false) String dataType, @RequestParam(name = "monitorCode", required = false) String monitorCode) {
        LambdaQueryWrapper<JyBaseMonitor> wrapper = new LambdaQueryWrapper<>();
        if (dataType != null) {
            wrapper.eq(JyBaseMonitor::getDataType, dataType);
        }
        if (monitorCode != null) {
            wrapper.eq(JyBaseMonitor::getMonitorCode, monitorCode);
        }
        List<JyBaseMonitor> jyBaseMonitors = jyBaseMonitorMapper.selectList(wrapper);
        return jyBaseMonitors;
    }

    @GetMapping("selectByMonitor2")
    public List<JyBaseMonitor> selectByMonitor2(@RequestParam(name = "dataType", required = false) String dataType, @RequestParam(name = "monitorCode", required = false) String monitorCode) {
        LambdaQueryWrapper<JyBaseMonitor> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(dataType != null, JyBaseMonitor::getDataType, dataType);
        wrapper.eq(monitorCode != null, JyBaseMonitor::getMonitorCode, monitorCode);
        List<JyBaseMonitor> jyBaseMonitors = jyBaseMonitorMapper.selectList(wrapper);
        return jyBaseMonitors;
    }

    @GetMapping("selectByMonitor3")
    public List<JyBaseMonitor> selectByMonitor3(@RequestParam(name = "dataType", required = false) String dataType, @RequestParam(name = "monitorCode", required = false) String monitorCode) {
//        LambdaQueryWrapper<JyBaseMonitor> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(dataType != null,JyBaseMonitor::getDataType, dataType);
//        wrapper.eq(monitorCode != null,JyBaseMonitor::getMonitorCode, monitorCode);
//        List<JyBaseMonitor> jyBaseMonitors = jyBaseMonitorMapper.selectList(wrapper);
        return jyBaseMonitorMapper.selectList(Wrappers.<JyBaseMonitor>lambdaQuery().eq(dataType != null, JyBaseMonitor::getDataType, dataType)
                .eq(monitorCode != null, JyBaseMonitor::getMonitorCode, monitorCode));
    }

    @GetMapping("selectByMonitor4")
    public List<JyBaseMonitor> selectByMonitor4(@RequestParam(name = "dataType", required = false) String dataType, @RequestParam(name = "monitorCode", required = false) String monitorCode) {
        LambdaQueryWrapper<JyBaseMonitor> wrapper = new LambdaQueryWrapper<>();
        //StringUtils.isNotBlank这个方法判断String类型是否为空 或者是空格符号等 string类型判空用StringUtils内置方法
        //StringUtils需要在pom文件中加入相关依赖
        wrapper.eq(StringUtils.isNotBlank(dataType), JyBaseMonitor::getDataType, dataType);
        wrapper.eq(StringUtils.isNotBlank(monitorCode), JyBaseMonitor::getMonitorCode, monitorCode);
        return jyBaseMonitorMapper.selectList(wrapper);
    }

    @GetMapping("selectByMonitor5")
    public List<JyBaseMonitor> selectByMonitor5(@RequestParam(name = "dataType", required = false) String dataType, @RequestParam(name = "monitorCode", required = false) String monitorCode) {
        return jyBaseMonitorMapper.selectList(Wrappers.<JyBaseMonitor>lambdaQuery().eq(StringUtils.isNotBlank(dataType), JyBaseMonitor::getDataType, dataType)
                .eq(StringUtils.isNotBlank(monitorCode), JyBaseMonitor::getMonitorCode, monitorCode));
    }
    @GetMapping("selectByMonitor6")
    public List<JyBaseMonitor> selectByMonitor6(@RequestParam(name = "dataType", required = false) String dataType, @RequestParam(name = "monitorCode", required = false) String monitorCode) {
        return jyBaseMonitorMapper.selectToMonitor(dataType,monitorCode);
    }
}
