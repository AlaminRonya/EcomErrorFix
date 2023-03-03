package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.Attributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributesRepository extends JpaRepository<Attributes, Long> {
}
