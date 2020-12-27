package com.udemy.course.ms.flightfare.controller;

import com.udemy.course.ms.flightfare.dao.FlightFareRepository;
import com.udemy.course.ms.flightfare.models.CurrencyConversionVo;
import com.udemy.course.ms.flightfare.models.FlightFare;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/api/v1/flight/{flightCode}/fare/{currency}")
public class FlightFareController {

  @Autowired
  private FlightFareRepository flightFareRepository;

  @Value("${base.currency:USD}")
  private String baseCurrency;


  @GetMapping
  public FlightFare getSingleTicketFare(@PathVariable("flightCode") String flightCode,
      @PathVariable("currency") String currency){
    FlightFare flightFare = new FlightFare();
    flightFare.setFlightCode(flightCode);
    Example<FlightFare> filterCriteria = Example.of(flightFare);
    FlightFare responseFare = flightFareRepository.findOne(filterCriteria).get();

    if(!baseCurrency.equals(currency)){
      BigDecimal conversionRate = getConversion(currency);
      BigDecimal convertedFare = responseFare.getFlightPrice().multiply(conversionRate);
      responseFare.setFlightPrice(convertedFare);
    }
    return responseFare;
  }

  private BigDecimal getConversion (String toCurrency){
    RestTemplate restTemplate = new RestTemplate();
    Map<String,String> map = new HashMap<>();
    map.put("from",baseCurrency);
    map.put("to", toCurrency);

    ResponseEntity<CurrencyConversionVo> responseEntity =
        restTemplate.getForEntity("http://localhost:7101/api/v1/from/{from}/to/{to}",
        CurrencyConversionVo.class,map);

    CurrencyConversionVo currencyConversionVo = responseEntity.getBody();
    return  currencyConversionVo.getConversionRate();

  }
}
