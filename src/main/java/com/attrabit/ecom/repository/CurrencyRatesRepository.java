package com.attrabit.ecom.repository;


import com.attrabit.ecom.model.CurrencyRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRatesRepository extends JpaRepository<CurrencyRates, Long> {
}
