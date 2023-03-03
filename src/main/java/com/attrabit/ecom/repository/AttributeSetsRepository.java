package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.AttributeSets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeSetsRepository extends JpaRepository<AttributeSets, Long> {

}
