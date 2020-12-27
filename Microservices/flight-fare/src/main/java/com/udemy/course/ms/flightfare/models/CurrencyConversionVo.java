package com.udemy.course.ms.flightfare.models;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class CurrencyConversionVo {

  private String currencyFrom;
  private String currencyTo;
  private BigDecimal conversionRate;
}
