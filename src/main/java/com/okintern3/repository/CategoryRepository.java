package com.okintern3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okintern3.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);
}
