package com.project.anatomy.repository.entity;

import javax.persistence.*;

@Entity
public class Friends {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long firstId;

    @Column(nullable = false)
    private Long secondId;

    public Friends() {
    }

    public Friends(Long firstId, Long secondId) {
        this.firstId = firstId;
        this.secondId = secondId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFirstId() {
        return firstId;
    }

    public void setFirstId(Long firstId) {
        this.firstId = firstId;
    }

    public Long getSecondId() {
        return secondId;
    }

    public void setSecondId(Long secondId) {
        this.secondId = secondId;
    }
}