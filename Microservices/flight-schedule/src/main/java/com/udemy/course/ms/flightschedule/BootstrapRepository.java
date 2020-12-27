package com.udemy.course.ms.flightschedule;

import com.udemy.course.ms.flightschedule.dao.FlightScheduleRepository;
import com.udemy.course.ms.flightschedule.models.Flight;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapRepository implements CommandLineRunner {

  private FlightScheduleRepository flightScheduleRepository;

  public BootstrapRepository(final FlightScheduleRepository flightScheduleRepository) {
    super();
    this.flightScheduleRepository = flightScheduleRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    flightScheduleRepository.deleteAll();

    List<Flight> flightList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      Flight flight = Flight.createFrom(Long.valueOf(i),"FL-1"+i,"DEL","TYO","DECCAN", LocalDateTime.now(),
          LocalDateTime.now().plusDays(3));
      flightList.add(flight);
    }
    flightScheduleRepository.saveAll(flightList);
    flightList.clear();
    for (int i = 11; i < 20; i++) {
      Flight flight = Flight.createFrom(Long.valueOf(i),"FL-1"+i,"DEL","TYO","INDIGO", LocalDateTime.now(),
          LocalDateTime.now().plusDays(3));
      flightList.add(flight);
    }
    flightScheduleRepository.saveAll(flightList);
    flightList.clear();
    for (int i = 21; i < 30; i++) {
      Flight flight = Flight.createFrom(Long.valueOf(i),"FL-1"+i,"TYO","DEL","KING", LocalDateTime.now(),
          LocalDateTime.now().plusDays(3));
      flightList.add(flight);
    }
    flightScheduleRepository.saveAll(flightList);
    flightList.clear();
  }
}
