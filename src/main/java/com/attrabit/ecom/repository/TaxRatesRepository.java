package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.TaxRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRatesRepository extends JpaRepository <TaxRates, Long> {

}
