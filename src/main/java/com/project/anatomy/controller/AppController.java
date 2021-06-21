package com.project.anatomy.controller;

import com.project.anatomy.ChooseQuizForm;
import com.project.anatomy.RankingPlacement;
import com.project.anatomy.UserInput;
import com.project.anatomy.repository.UserRepository;
import com.project.anatomy.repository.entity.Answer;
import com.project.anatomy.repository.entity.Friends;
import com.project.anatomy.repository.entity.User;
import com.project.anatomy.service.AnswerManager;
import com.project.anatomy.service.FriendsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.*;

@Controller
public class AppController {

    @Autowired
    private UserRepository repo;

    private AnswerManager answersList;
    private FriendsManager friendsManager;
    private int test = 0;

    @Autowired
    public AppController(AnswerManager answersList, FriendsManager friendsManager) {
        this.answersList = answersList;
        this.friendsManager = friendsManager;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("options", new ChooseQuizForm());
        return "index";
    }

    @GetMapping("/register")
    public String viewRegisterPage(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        repo.save(user);
        return "register_success";
    }

    @GetMapping("/list_users")
    public String viewUsersList(Model model, Principal principal) {

        String login = principal.getName();
        User user = repo.findByLogin(login);

        model.addAttribute("user", user);
        model.addAttribute("userInput", new UserInput());

        List<Friends> friendsList = friendsManager.findByFirstId(user.getId());
        ArrayList<RankingPlacement> ranking = new ArrayList<>();
        ranking.add(new RankingPlacement(user.getLogin(), user.getPoints()));

        for(int i=0; i<friendsList.size(); i++){
            String username = repo.findById(friendsList.get(i).getSecondId()).get().getLogin();
            int points = repo.findById(friendsList.get(i).getSecondId()).get().getPoints();
            ranking.add(new RankingPlacement(username, points));
        }

        ranking.sort(Comparator.comparing(RankingPlacement::getPoints).reversed());
        model.addAttribute("ranking", ranking);

        return "users";
    }

    @GetMapping("/about_flashcards")
    public String viewAboutFlashcards(){
        return "aboutFlashcards";
    }

    @GetMapping("/about_quiz")
    public String viewAboutQuiz(){
        return "aboutQuiz";
    }

   /* @PostMapping("/update_login")
    public String processLoginUpdate(User user){
        user.setLogin(login);

    }*/

}
