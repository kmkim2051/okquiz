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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<QuizOption> options = new ArrayList<>();

    private Long answerOptionId;

    private String answerDescription;

    public Quiz(String question, Category category, Long answerOptionId, String answerDescription) {
        this.question = question;
        this.category = category;
        this.answerOptionId = answerOptionId;
        this.answerDescription = answerDescription;
    }

    public void addOption(QuizOption option) {
        options.add(option);
    }
}
