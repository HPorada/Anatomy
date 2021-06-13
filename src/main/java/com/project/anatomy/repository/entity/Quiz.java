package com.project.anatomy.repository.entity;

import javax.persistence.*;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quiz_id;

    @Column(nullable = false, length = 30)
    private String quizName;

    @Column(nullable = false, length = 100)
    private String quiz_description;

    @Column(nullable = false)
    private int max_points;

    @Column(nullable = false, length = 100)
    private String category;

    public Quiz() {
    }

    public Quiz(String quizName, String quiz_description, int max_points, String category) {
        this.quizName = quizName;
        this.quiz_description = quiz_description;
        this.max_points = max_points;
        this.category = category;
    }

    public Long getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(Long quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quiz_name) {
        this.quizName = quiz_name;
    }

    public String getQuiz_description() {
        return quiz_description;
    }

    public void setQuiz_description(String quiz_description) {
        this.quiz_description = quiz_description;
    }

    public int getMax_points() {
        return max_points;
    }

    public void setMax_points(int max_points) {
        this.max_points = max_points;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
