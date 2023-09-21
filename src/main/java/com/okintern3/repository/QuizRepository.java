package com.okintern3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okintern3.entity.Category;
import com.okintern3.entity.Quiz;


public interface QuizRepository extends JpaRepository<Quiz, Long> {

   List<Quiz> findByCategory(Category category);
}
