package com.udemy.course.ms.flightschedule.controller;

import com.udemy.course.ms.flightschedule.models.Flight;
import com.udemy.course.ms.flightschedule.services.FlightScheduleService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/flights")
public class FlightScheduleController {

  @Autowired
  private FlightScheduleService flightScheduleService;

  @GetMapping(value = "/from/{from}/to/{to}")
  public List<Flight> getFlights(@PathVariable("from") String from, @PathVariable("to") String to){
    List<Flight> flightList = flightScheduleService.getFlights(from,to);

    return flightList;
  }
}
