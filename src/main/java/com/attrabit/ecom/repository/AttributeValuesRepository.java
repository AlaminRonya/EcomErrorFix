package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.AttributeValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeValuesRepository extends JpaRepository<AttributeValues, Long> {
}
