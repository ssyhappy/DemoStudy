package com.xiaojin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
@TableName("jy_base_monitor")
@NoArgsConstructor
@AllArgsConstructor
public class JyBaseMonitor implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String monitorName;

    private String monitorCode;

    private String monitorType;

    /**
     * 单位
     */
    private String unit;

    private Double pt;

    private Double ct;

    private Double multiple;

    /**
     * 能源及耗能工质种类
     */
    private String dataType;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    private Integer isUpload;

    private Double uploadFactor;

}
