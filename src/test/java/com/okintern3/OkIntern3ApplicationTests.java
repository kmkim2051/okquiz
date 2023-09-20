package com.okintern3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.okintern3.entity.Category;
import com.okintern3.entity.Quiz;
import com.okintern3.entity.QuizOption;
import com.okintern3.entity.QuizType;
import com.okintern3.repository.CategoryRepository;
import com.okintern3.repository.QuizRepository;

@SpringBootTest
class OkIntern3ApplicationTests {

	@Autowired
	private QuizRepository quizRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void contextLoads() {
	}

	@AfterEach
	void clearRepository() {
		quizRepository.deleteAll();
		categoryRepository.deleteAll();
	}

	@Test
	void 퀴즈_생성_확인() {
		// given
		Category category = new Category("클라우드");

		Quiz quiz = new Quiz("question1", category, QuizType.MULTI_OPTION);
		QuizOption quizOption = new QuizOption("answer",  true, quiz, "this is answer");
		QuizOption quizOption2 = new QuizOption("not answer1", false, quiz);
		QuizOption quizOption3 = new QuizOption("not answer2", false, quiz);
		QuizOption quizOption4 = new QuizOption("not answer3", false, quiz);

		quizRepository.save(quiz);

		// when
		Quiz findQuiz = quizRepository.findByCategory(category).get(0);

		// then
		Assertions.assertThat(findQuiz.getQuestion()).isEqualTo("question1");
		Assertions.assertThat(findQuiz.getQuizType()).isEqualTo(QuizType.MULTI_OPTION);
	}
}
