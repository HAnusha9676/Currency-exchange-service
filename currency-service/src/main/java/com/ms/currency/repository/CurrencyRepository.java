package com.ms.currency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.currency.entity.CurrencyConversion;
@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyConversion,Long> {

}
