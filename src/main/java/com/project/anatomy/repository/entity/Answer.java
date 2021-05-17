package com.project.anatomy.repository.entity;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long answer_id;

    @Column(nullable = false, length = 100)
    private String pol_body;

    @Column(nullable = false, length = 100)
    private String lat_body;

    @Column(nullable = false, length = 100)
    private String eng_bodyc;

    public Answer() {
    }

    public Answer(Long answer_id, String pol_body, String lat_body, String eng_bodyc) {
        this.answer_id = answer_id;
        this.pol_body = pol_body;
        this.lat_body = lat_body;
        this.eng_bodyc = eng_bodyc;
    }

    public Long getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Long answer_id) {
        this.answer_id = answer_id;
    }

    public String getPol_body() {
        return pol_body;
    }

    public void setPol_body(String pol_body) {
        this.pol_body = pol_body;
    }

    public String getLat_body() {
        return lat_body;
    }

    public void setLat_body(String lat_body) {
        this.lat_body = lat_body;
    }

    public String getEng_bodyc() {
        return eng_bodyc;
    }

    public void setEng_bodyc(String eng_bodyc) {
        this.eng_bodyc = eng_bodyc;
    }
}
