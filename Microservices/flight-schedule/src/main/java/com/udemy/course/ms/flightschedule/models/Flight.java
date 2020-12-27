package com.udemy.course.ms.flightschedule.models;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data

@Entity
public class Flight {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String flightCode;
  private String flightFrom;
  private String flightTo;
  private String airline;
  private LocalDateTime departureTime;
  private LocalDateTime arrivalTime;

  public static Flight createFrom(Long id, String flightCode,String flightFrom,
      String flightTo, String airline, LocalDateTime departureTime,
      LocalDateTime arrivalTime){

    Flight flight = new Flight();
    flight.setId(id);
    flight.setFlightCode(flightCode);
    flight.setAirline(airline);
    flight.setArrivalTime(arrivalTime);
    flight.setDepartureTime(departureTime);
    flight.setFlightFrom(flightFrom);
    flight.setFlightTo(flightTo);
    return flight;

  }


}
