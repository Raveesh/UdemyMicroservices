package com.udemy.course.ms.currencyconversion;

import com.udemy.course.ms.currencyconversion.dao.CurrencyConverterRepository;
import com.udemy.course.ms.currencyconversion.models.CurrencyConverter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapRepository implements CommandLineRunner {

  private CurrencyConverterRepository currencyConverterRepository;

  public BootstrapRepository(final CurrencyConverterRepository currencyConverterRepository){
  super();
  this.currencyConverterRepository = currencyConverterRepository;
  }


  @Override
  public void run(String... args) throws Exception {

    currencyConverterRepository.deleteAll();

    List<CurrencyConverter> currencyConverterList  = new ArrayList<>();
    CurrencyConverter currencyConverter = CurrencyConverter.
        from(1L,"USD","INR",
            BigDecimal.valueOf(74.10));
    CurrencyConverter currencyConverter2 = CurrencyConverter.
        from(2L,"USD","JPY",
            BigDecimal.valueOf(111.12));
    currencyConverterList.add(currencyConverter);
    currencyConverterList.add(currencyConverter2);
    currencyConverterRepository.saveAll(currencyConverterList);
    currencyConverterList.clear();



  }
}
