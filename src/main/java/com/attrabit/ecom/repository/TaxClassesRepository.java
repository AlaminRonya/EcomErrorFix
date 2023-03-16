package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.TaxClasses;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface TaxClassesRepository extends JpaRepository<TaxClasses, Long> {
    Optional<TaxClasses> findByBasedOn(String basedOn);
}
