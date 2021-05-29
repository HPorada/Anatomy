package com.project.anatomy.repository.entity;

import javax.persistence.*;

@Entity
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ranking_id;

    @Column(nullable = false)
    private String creation;

    public Ranking() {
    }

    public Ranking(Long ranking_id, String creation) {
        this.ranking_id = ranking_id;
        this.creation = creation;
    }

    public Long getRanking_id() {
        return ranking_id;
    }

    public void setRanking_id(Long ranking_id) {
        this.ranking_id = ranking_id;
    }

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }
}
