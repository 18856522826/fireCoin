package com.example.firecoinapi.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Notice:
 *
 * @author xuxu
 * @version 1.0
 * @date 2021/5/17
 * @since 1.0
 */
@Component
@Data
public class Kmodel {
 /**
  * K线ID
  */
 private String kLineId;
 /**
  * 金额
  */
 private BigDecimal amount;
 /**
  * 状态 1-最低 2-最高  3-上升趋势  4-下降趋势
  */
 private String status;
}
