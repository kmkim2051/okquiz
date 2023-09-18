package com.okintern3.repository;


import com.okintern3.entity.Category;
import com.okintern3.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    public List<Quiz> findByCategory(Category category);
}
