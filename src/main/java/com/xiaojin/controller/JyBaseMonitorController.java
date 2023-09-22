package com.xiaojin.controller;



import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiaojin.dao.JyBaseMonitorMapper;
import com.xiaojin.dao.JyDataElec0012020Mapper;
import com.xiaojin.domain.JyBaseMonitor;
import com.xiaojin.req.MonitorReq;
import com.xiaojin.req.MonthToReq;
import com.xiaojin.req.MonthToReq2;
import com.xiaojin.rsp.MonitorRsp;
import com.xiaojin.rsp.MonthRsp;
import com.xiaojin.rsp.MonthRsp2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sushaoyou
 * @since 2023-09-21
 */
@RestController
@RequestMapping("/monitor")
public class JyBaseMonitorController {
    @Autowired
    private JyBaseMonitorMapper jyBaseMonitorMapper;
    @Autowired
    private JyDataElec0012020Mapper jyDataElec0012020Mapper;

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
    @PostMapping("/elec")
    public MonitorRsp selectElecData(@RequestBody MonitorReq monitorReq){
        DateTime dateTime = DateUtil.beginOfMonth(monitorReq.getStartTime());
        System.out.println("dateTime = " + dateTime);
        DateTime endOfMonth = DateUtil.endOfMonth(monitorReq.getEndTime());
        System.out.println("endOfMonth = " + endOfMonth);
        MonitorRsp monitorRsps = jyDataElec0012020Mapper.selectByXml(monitorReq);
        System.out.println("monitorRsps = " + monitorRsps);
//        List<DateTime> dateTimes = DateUtil.rangeToList(dateTime, endOfMonth, DateField.DAY_OF_MONTH, 1);
//        dateTimes.forEach(t->{
//            System.out.println("t = " + t);
//                }
//        );

        return monitorRsps;
    }
    @PostMapping("/elecMonth")
    public List<MonthRsp> selectMonthData(@RequestBody MonthToReq month){
        int currentYear = DateUtil.year(DateUtil.date());
        Calendar calendar = DateUtil.calendar(DateUtil.date());
        calendar.set(currentYear, month.getMonth() - 1, 1, 0, 0, 0);
        Date targetDate = calendar.getTime();
        DateTime endOfMonth = DateUtil.endOfMonth(targetDate);
        List<DateTime> dateTimes = DateUtil.rangeToList(targetDate, endOfMonth, DateField.DAY_OF_MONTH, 1);
        List<MonthRsp> list = new ArrayList<>();
        dateTimes.forEach(t->{
            System.out.println("t = " + t);
            MonitorReq monitorReq = new MonitorReq();
            monitorReq.setMonitorId(month.getMonitorId());
            monitorReq.setStartTime(DateUtil.beginOfDay(t));
            monitorReq.setEndTime(DateUtil.endOfDay(t));
            MonitorRsp monitorRsp = jyDataElec0012020Mapper.selectByXml(monitorReq);
            MonthRsp monthRsp = new MonthRsp();
            monthRsp.setCollectTime(t);
            if (Objects.isNull(monitorRsp)){
                monthRsp.setTotalSum(0d);
            }else {
                monthRsp.setTotalSum(monitorRsp.getTotalSum());
            }
            list.add(monthRsp);
        });
        return list;
    }
    @PostMapping("/elecMonth2")
    public List<MonthRsp2> selectMonthData2(@RequestBody MonthToReq2 month){
        if (month.getYear() == null){
            month.setYear(2023);
        }
        //11
        Calendar calendar = DateUtil.calendar(DateUtil.date());
        calendar.set(month.getYear(), month.getMonth() - 1, 1, 0, 0, 0);
        Date targetDate = calendar.getTime();
        DateTime endOfMonth = DateUtil.endOfMonth(targetDate);
        List<DateTime> dateTimes = DateUtil.rangeToList(targetDate, endOfMonth, DateField.DAY_OF_MONTH, 1);
        HashMap<Date, Double> map = new HashMap<>();
        List<MonthRsp2> list = new ArrayList<>();
        dateTimes.forEach(t->{
            map.put(DateUtil.beginOfDay(t),0d);
        });
        List<MonthRsp2> monthRsp2s = jyDataElec0012020Mapper.selectByXmlMonth(month);
        monthRsp2s.forEach(k->{
            if (map.containsKey(DateUtil.beginOfDay(k.getCollectTime()))){
                map.put(k.getCollectTime(),k.getTotalSum());
            }
        });
        map.forEach((k,v)->{
            MonthRsp2 monthRsp2 = new MonthRsp2();
            monthRsp2.setCollectTime(k);
            monthRsp2.setTotalSum(v);
            list.add(monthRsp2);
        });
        return list.stream().sorted(Comparator.comparing(MonthRsp2::getCollectTime)).collect(Collectors.toList());
    }
}
