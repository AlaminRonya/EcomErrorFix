package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CouponsRepository extends CrudRepository<Coupons, Long> {

    List<Coupons> findAll();
}

