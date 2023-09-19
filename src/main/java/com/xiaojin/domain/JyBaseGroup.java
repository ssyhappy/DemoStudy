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

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaojin
 * @since 2023-09-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("jy_base_group")
@NoArgsConstructor
@AllArgsConstructor
public class JyBaseGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分组id
     */
    @TableId(value = "group_id", type = IdType.AUTO)
    private Long groupId;

    /**
     * 名称
     */
    private String groupName;

    /**
     * 父级id
     */
    private Integer parentId;

    /**
     * 分组类别
     */
    private String groupCategory;

    /**
     * 祖级列表
     */
    private String ancestors;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 显示顺序
     */
    private Integer sort;

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


}
