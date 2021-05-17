package com.project.anatomy.repository.entity;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long question_id;

    @Column(nullable = false, length = 100)
    private String body;

    @Column(nullable = false, length = 100)
    private String image;

    public Question() {
    }

    public Question(Long question_id, String body, String image) {
        this.question_id = question_id;
        this.body = body;
        this.image = image;
    }

    public Long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
