package com.project.anatomy.controller;

import com.project.anatomy.ChooseQuizForm;
import com.project.anatomy.repository.UserRepository;
import com.project.anatomy.repository.entity.Answer;
import com.project.anatomy.repository.entity.User;
import com.project.anatomy.service.AnswerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserRepository repo;

    private AnswerManager answersList;
    private int test=0;

    @Autowired
    public AppController(AnswerManager answersList) {
        this.answersList = answersList;
    }

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("options", new ChooseQuizForm());
        return "index";
    }

    @GetMapping("/register")
    public String viewRegisterPage(Model model){
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        repo.save(user);
        return "register_success";
    }

    @GetMapping("/list_users")
    public String viewUsersList(){
/*
        model.addAttribute("options", new ChooseQuizForm());
*/
        return "users";
    }

}
