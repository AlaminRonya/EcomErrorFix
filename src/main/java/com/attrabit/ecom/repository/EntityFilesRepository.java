// EntityFilesRepository.java
package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.EntityFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityFilesRepository extends JpaRepository<EntityFiles, Long> {
    // any custom methods can be defined here
}

