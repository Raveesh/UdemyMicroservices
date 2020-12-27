package com.udemy.course.ms.currencyconversion.models;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CurrencyConverter {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String currencyFrom;
  private String currencyTo;
  private BigDecimal conversionRate;

  public static CurrencyConverter from (Long id, String currencyFrom,String currencyTo,BigDecimal conversionRate){
    CurrencyConverter currencyConverter = new CurrencyConverter();
    currencyConverter.setConversionRate(conversionRate);
    currencyConverter.setCurrencyFrom(currencyFrom);
    currencyConverter.setCurrencyTo(currencyTo);
    currencyConverter.setId(id);
    return currencyConverter;
  }
}
