package com.okintern3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Quiz extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long id;

    private String question;

    @Enumerated(EnumType.STRING)
    private QuizType quizType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private final List<QuizOption> options = new ArrayList<>();

    public Quiz(String question, Category category, QuizType quizType) {
        this.question = question;
        this.category = category;
        this.quizType = quizType;
    }

    public void addOption(QuizOption option) {
        options.add(option);
    }

}
