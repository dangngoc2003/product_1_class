package com.example.product1.repository;

import com.example.product1.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ICrudProduct extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p from Product as p where p.name like :name")
    public Page<Product> findName(@Param("name") String name, Pageable pageable);
}
