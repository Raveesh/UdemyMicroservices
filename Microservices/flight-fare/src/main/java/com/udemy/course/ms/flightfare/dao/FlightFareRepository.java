package com.udemy.course.ms.flightfare.dao;

import com.udemy.course.ms.flightfare.models.FlightFare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface FlightFareRepository extends JpaRepository<FlightFare,Long> , QueryByExampleExecutor<FlightFare> {


}
