package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.Activations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivationsRepository extends JpaRepository<Activations, Long> {
}
