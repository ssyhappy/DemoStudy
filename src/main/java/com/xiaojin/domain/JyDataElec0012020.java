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
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author sushaoyou
 * @since 2023-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("jy_data_elec_h_2020")
@AllArgsConstructor
@NoArgsConstructor
public class JyDataElec0012020 implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 监测点id
     */
    private Integer monitorId;

    /**
     * 采集时间
     */
    private Date collectTime;

    private Float vA;

    private Float vB;

    private Float vC;

    private Float cA;

    private Float cB;

    private Float cC;

    private Float actT;

    private Float actA;

    private Float actB;

    private Float actC;

    private Float reaT;

    private Float reaA;

    private Float reaB;

    private Float reaC;

    private Float pfT;

    private Float pfA;

    private Float pfB;

    private Float pfC;

    /**
     * 正向总有功电能
     */
    private Float actDisplayP;

    private Float reaDisplayP;

    private Float actPowerP;

    private Float reaPowerP;

    private Float actPowerN;

    private Float reaPowerN;

    private Float demand;

    private String usedElecTime;

    /**
     * 总视在功率
     */
    private Float appT;

    /**
     * 反向总有功电能
     */
    private Float actDisplayN;

    /**
     * 反向无功电能
     */
    private Float reaDisplayN;

    private Float actTipDisplay;

    private Float actPeakDisplay;

    private Float actFlatDisplay;

    private Float actValleyDisplay;


}
