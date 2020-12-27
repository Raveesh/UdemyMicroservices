package com.udemy.course.ms.currencyconversion.controller;

import com.udemy.course.ms.currencyconversion.dao.CurrencyConverterRepository;
import com.udemy.course.ms.currencyconversion.models.CurrencyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class ConvertCurrencyController {

  @Autowired
  private CurrencyConverterRepository currencyConverterRepository;

  @GetMapping(value = "/from/{from}/to/{to}")
  public CurrencyConverter convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to){
    CurrencyConverter currencyConverter = CurrencyConverter.from(null,from,to,null);
    Example<CurrencyConverter> filterCriteria = Example.of(currencyConverter);
    return currencyConverterRepository.findOne(filterCriteria).get();
  }
}
