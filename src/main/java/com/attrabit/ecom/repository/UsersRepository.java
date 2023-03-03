package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.Addresses;
import com.attrabit.ecom.model.Attachment;
import com.attrabit.ecom.model.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE Users u " +
            "SET u.attachment =?2, u.addresses= ?3 WHERE u.id = ?1")
    int updatedUsersInfoById(Long id, Attachment attachment, Addresses addresses);

}
