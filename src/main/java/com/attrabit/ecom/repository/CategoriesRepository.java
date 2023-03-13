package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.Addresses;
import com.attrabit.ecom.model.Attachment;
import com.attrabit.ecom.model.Categories;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    Optional<Categories> findBySlug(String slug);
    Optional<List<Categories>> findAllByParent(Categories categories);

}
