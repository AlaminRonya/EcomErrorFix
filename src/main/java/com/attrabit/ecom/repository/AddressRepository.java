package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.Addresses;
import com.attrabit.ecom.model.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface AddressRepository extends JpaRepository<Addresses, Long> {
    Optional<Addresses> findByCustomers(Users customer);
}
