package com.okintern3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class QuizOption extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long id;

    private String text;

    private String description;

    private boolean isAnswer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public QuizOption(String text, boolean isAnswer, Quiz quiz) {
        this(text, isAnswer, quiz, null);
    }

    public QuizOption(String text, boolean isAnswer, Quiz quiz, String description) {
        this.text = text;
        this.description = description;
        this.isAnswer = isAnswer;
        this.quiz = quiz;
        quiz.addOption(this);
    }
}
