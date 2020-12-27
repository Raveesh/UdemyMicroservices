package com.udemy.course.ms.flightfare;

import com.udemy.course.ms.flightfare.dao.FlightFareRepository;
import com.udemy.course.ms.flightfare.models.FlightFare;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapRepository  implements CommandLineRunner {

  private FlightFareRepository flightFareRepository;

  public BootstrapRepository(final FlightFareRepository flightFareRepository) {
    super();
    this.flightFareRepository = flightFareRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    flightFareRepository.deleteAll();
    FlightFare flightFare = FlightFare.from(1L,"UL-1", BigDecimal.valueOf(1000),"USD");
    FlightFare flightFare2 = FlightFare.from(2L,"UL-2", BigDecimal.valueOf(2000),"USD");
    FlightFare flightFare3 = FlightFare.from(3L,"UL-3", BigDecimal.valueOf(3000),"USD");
    FlightFare flightFare4 = FlightFare.from(4L,"UL-4", BigDecimal.valueOf(4000),"USD");

    List<FlightFare> flightFareList = new ArrayList<>();
    flightFareList.add(flightFare);
    flightFareList.add(flightFare2);
    flightFareList.add(flightFare3);
    flightFareList.add(flightFare4);
    flightFareRepository.saveAll(flightFareList);
    flightFareList.clear();
  }
}
