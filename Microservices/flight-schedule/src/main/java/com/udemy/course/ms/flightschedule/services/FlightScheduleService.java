package com.udemy.course.ms.flightschedule.services;

import com.udemy.course.ms.flightschedule.models.Flight;
import java.util.List;

public interface FlightScheduleService {

  List<Flight> getFlights (String from, String to);
}
