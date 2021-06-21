package com.project.anatomy.controller;

import com.project.anatomy.ChooseQuizForm;
import com.project.anatomy.RankingPlacement;
import com.project.anatomy.UserInput;
import com.project.anatomy.repository.entity.Answer;
import com.project.anatomy.repository.entity.Friends;
import com.project.anatomy.repository.entity.User;
import com.project.anatomy.service.AnswerManager;
import com.project.anatomy.service.FriendsManager;
import com.project.anatomy.service.QuizManager;
import com.project.anatomy.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.security.Principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class FriendsController {

    private FriendsManager friendsManager;
    private UserManager userManager;

    @Autowired
    public FriendsController(FriendsManager friendsManager, UserManager userManager) {
        this.friendsManager = friendsManager;
        this.userManager = userManager;
    }

    @PostMapping("/addFriend")
    public String addFriend(Model model, @ModelAttribute UserInput userInput, Principal principal) {
        String message = "";

        String friendName = userInput.getInput();
        Long userId = userManager.findByLogin(principal.getName()).getId();
        Long friendId = userManager.findByLogin(friendName).getId();
        message = "Added " + friendName + " to your friends!";

        friendsManager.save(new Friends(userId, friendId));

        model.addAttribute("userInput", new UserInput());

        String login = principal.getName();
        User user = userManager.findByLogin(login);
        model.addAttribute("user", user);

        model.addAttribute("message", message);

        List<Friends> friendsList = friendsManager.findByFirstId(user.getId());
        ArrayList<RankingPlacement> ranking = new ArrayList<>();
        ranking.add(new RankingPlacement(login, user.getPoints()));

        for(int i=0; i<friendsList.size(); i++){
            String username = userManager.findById(friendsList.get(i).getSecondId()).get().getLogin();
            int points = userManager.findById(friendsList.get(i).getSecondId()).get().getPoints();
            ranking.add(new RankingPlacement(username, points));
        }

        ranking.sort(Comparator.comparing(RankingPlacement::getPoints).reversed());
        model.addAttribute("ranking", ranking);

        return "users";
    }
}