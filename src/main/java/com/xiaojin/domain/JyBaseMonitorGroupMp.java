package com.xiaojin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author sushaoyou
 * @since 2023-09-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@TableName("jy_base_monitor_group_mp")
public class JyBaseMonitorGroupMp implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分组id
     */
    private Long groupId;

    /**
     * 监测点id
     */
    private Long monitorId;

    /**
     * 能源、生产数据类型id
     */
    private String dataCategoryId;

    /**
     * 是否为主监测点
     */
    private Integer isMain;

    /**
     * 监测点类别
     */
    private String monitorType;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
