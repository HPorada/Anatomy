package com.project.anatomy.repository.entity;

import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String login;

    @Column(nullable = false, length = 64) //encoded password (>)
    private String password;

    @Column(nullable = false, length = 100)
    private String email;
    private int points;


    public User() {
    }

    public User(Long id, String login, String password, String email, int points) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
