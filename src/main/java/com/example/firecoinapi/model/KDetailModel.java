package com.example.firecoinapi.model;

import lombok.Data;
import sun.dc.pr.PRError;

import java.math.BigDecimal;

/**
 * Notice:
 *
 * @author xuxu
 * @version 1.0
 * @date 2021/5/17
 * @since 1.0
 */
@Data
public class KDetailModel {
    private String id;
    private BigDecimal open;
    private BigDecimal close;
    private BigDecimal low;
    private BigDecimal high;
    private BigDecimal amount;
    private BigDecimal vol;
    private BigDecimal trade_turnover;
    private BigDecimal count;
}
