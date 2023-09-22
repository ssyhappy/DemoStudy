package com.xiaojin.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthToReq2 implements Serializable {
    private Long monitorId;
    private Integer month;
    private Integer year;





}
