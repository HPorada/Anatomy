package com.project.anatomy.controller;

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

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserRepository repo;

    private AnswerManager answersList;

    @Autowired
    public AppController(AnswerManager answersList) {
        this.answersList = answersList;
    }

    @GetMapping("/")
    public String viewHomePage(){
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
        return "users";
    }

    @GetMapping("/flashcard")
    public String viewFlashcard(Model model){
        Long id = 1L;
        model.addAttribute("eng", answersList.findById(id).get().getEng_bodyc());
        model.addAttribute("lat", answersList.findById(id).get().getLat_body());
        model.addAttribute("pol", answersList.findById(id).get().getPol_body());
        model.addAttribute("image", "Images/" + answersList.findById(id).get().getImage());
        model.addAttribute("id", answersList.findById(id).get().getAnswer_id());
        return "flashcard";
    }

    @GetMapping("/nextFlashcard")
    public String viewNextFlashcard(Model model){
        Long id = 2L;
        model.addAttribute("eng", answersList.findById(id).get().getEng_bodyc());
        model.addAttribute("lat", answersList.findById(id).get().getLat_body());
        model.addAttribute("pol", answersList.findById(id).get().getPol_body());
        model.addAttribute("image", "Images/" + answersList.findById(id).get().getImage());
        model.addAttribute("id", answersList.findById(id).get().getAnswer_id());
        return "flashcard";
    }
}
