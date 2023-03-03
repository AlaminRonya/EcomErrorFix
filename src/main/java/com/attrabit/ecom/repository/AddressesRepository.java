package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepository extends JpaRepository<Addresses, Long> {
    // add custom query methods here if needed
}
