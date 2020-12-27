package com.udemy.course.ms.currencyconversion.dao;

import com.udemy.course.ms.currencyconversion.models.CurrencyConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface CurrencyConverterRepository extends JpaRepository<CurrencyConverter,Long> ,
    QueryByExampleExecutor<CurrencyConverter> {

}
