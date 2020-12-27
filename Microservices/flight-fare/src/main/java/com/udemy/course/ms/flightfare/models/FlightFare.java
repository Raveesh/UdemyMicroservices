package com.udemy.course.ms.flightfare.models;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FlightFare {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String flightCode;
  private BigDecimal flightPrice;
  private String currency;


  public static FlightFare from (Long id, String flightCode,BigDecimal flightPrice,String currency){
    FlightFare flightFareObj = new FlightFare();
    flightFareObj.setCurrency(currency);
    flightFareObj.setFlightCode(flightCode);
    flightFareObj.setFlightPrice(flightPrice);
    flightFareObj.setId(id);
    return flightFareObj;

  }

}
