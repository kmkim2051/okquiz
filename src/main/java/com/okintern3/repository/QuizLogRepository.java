package com.okintern3.repository;

import com.okintern3.entity.QuizLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuizLogRepository extends JpaRepository<QuizLog, Long> {
    @Query("SELECT COUNT(ql) FROM QuizLog ql WHERE ql.quizId = :quizId and ql.isCorrect = true")
    Long countCorrectAnswers(@Param("quizId") Long quizId);

    Long countByQuizId(Long quizId);

    default Double calculateAnswerRatio(Long quizId) {
        Long correctCount = countCorrectAnswers(quizId);

        Long entireCount = countByQuizId(quizId);

        if (entireCount == 0) {
            return 0.0;
        }

        return (double) correctCount / entireCount;
    }
}
