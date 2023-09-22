package com.xiaojin.rsp;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
public class MonitorRsp implements Serializable {
    @TableField("monitor_id")
    private Long monitorId;
    /**
     * 创建时间
     */
    @TableField("total_sum")
    private Double totalSum;





}
