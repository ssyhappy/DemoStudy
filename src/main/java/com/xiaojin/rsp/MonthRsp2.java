package com.xiaojin.rsp;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class MonthRsp2 implements Serializable {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField("collect_time")
    private Date collectTime;
    /**
     * 创建时间
     */
    @TableField("total_sum")
    private Double totalSum;





}
