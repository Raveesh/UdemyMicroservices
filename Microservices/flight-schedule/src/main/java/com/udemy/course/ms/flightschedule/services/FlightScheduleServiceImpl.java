package com.udemy.course.ms.flightschedule.services;

import com.udemy.course.ms.flightschedule.dao.FlightScheduleRepository;
import com.udemy.course.ms.flightschedule.models.Flight;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class FlightScheduleServiceImpl implements FlightScheduleService {


  @Value("${airline.disabled}")
  private String airlineDisabled;


  private FlightScheduleRepository flightScheduleRepository;

  public FlightScheduleServiceImpl(FlightScheduleRepository flightScheduleRepository) {
    this.flightScheduleRepository = flightScheduleRepository;
  }

  @Override
  public List<Flight> getFlights(String from, String to) {

    Flight filterCriteria = new Flight();
    filterCriteria.setFlightFrom(from);
    filterCriteria.setFlightTo(to);

    Example<Flight> flightCriteriaExample = Example.of(filterCriteria);
    List<Flight> flightsByCriteria = flightScheduleRepository.findAll(flightCriteriaExample);

    if (!CollectionUtils.isEmpty(flightsByCriteria)) {
      flightsByCriteria = flightsByCriteria
          .stream()
          .filter(flight ->
            !airlineDisabled.equals(flight.getAirline()))
          .collect(Collectors.toList());
    }
    return flightsByCriteria;

  }
}
