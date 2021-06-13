package com.project.anatomy.controller;

import com.project.anatomy.ChooseQuizForm;
import com.project.anatomy.UserInput;
import com.project.anatomy.repository.entity.Answer;
import com.project.anatomy.repository.entity.User;
import com.project.anatomy.service.AnswerManager;
import com.project.anatomy.service.QuizManager;
import com.project.anatomy.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.security.Principal;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AnswerController {

    private AnswerManager answersList;
    private UserManager userManager;
    private QuizManager quiz;

    private Long quizId=0L; //id quizu
    private List<Answer> questionsList = new ArrayList<>();
    private Long questionNumber=0L; //numer pytania
    private Long lastQuestion=0L; //numer ostatniego pytania
    private int questions=0; //ile pytań
    private String quizDesc="";
    private String language="";

    private int points=0; //punkty

    @Autowired
    public AnswerController(AnswerManager answersList, QuizManager quiz, UserManager userManager) {
        this.answersList = answersList;
        this.quiz = quiz;
        this.userManager=userManager;
    }

    @PostMapping("/flashcard")
    public String viewFlashcard(Model model, @ModelAttribute ChooseQuizForm options){

        String quizName = options.getName();
        quizId = quiz.findByName(quizName).get().getQuiz_id();
        quizDesc = quiz.findByName(quizName).get().getQuiz_description();
        questionsList = answersList.findByQuizId(quizId);
        questionNumber = questionsList.get(0).getAnswer_id();
        questions = questionsList.size();
        lastQuestion = questionsList.get(questions-1).getAnswer_id()+1;

        model.addAttribute("desc", quizDesc);
        model.addAttribute("eng", "English: " + answersList.findById(questionNumber).get().getEng_bodyc());
        model.addAttribute("lat", "Latinum: " + answersList.findById(questionNumber).get().getLat_body());
        model.addAttribute("pol", "Polski: " + answersList.findById(questionNumber).get().getPol_body());
        model.addAttribute("image", "Images/" + answersList.findById(questionNumber).get().getImage());

        return "flashcard";
    }

    @GetMapping("/nextFlashcard")
    public String viewNextFlashcard(Model model){
        questionNumber=questionNumber+1L;
        String page="";

        if(questionNumber!=lastQuestion) {
            model.addAttribute("desc", quizDesc);
            model.addAttribute("eng", "English: " + answersList.findById(questionNumber).get().getEng_bodyc());
            model.addAttribute("lat", "Latinum: " + answersList.findById(questionNumber).get().getLat_body());
            model.addAttribute("pol", "Polski: " + answersList.findById(questionNumber).get().getPol_body());
            model.addAttribute("image", "Images/" + answersList.findById(questionNumber).get().getImage());
            page="flashcard";
        }
        else {
            page="endFlashcard";
        }
        return page;
    }

    @PostMapping("/quiz")
    public String viewQuiz(Model model, @ModelAttribute ChooseQuizForm options){

        points=0;

        model.addAttribute("userInput", new UserInput());

        String quizName = options.getName();
        language = options.getLanguage();
        quizId = quiz.findByName(quizName).get().getQuiz_id();
        quizDesc = quiz.findByName(quizName).get().getQuiz_description();
        questionsList = answersList.findByQuizId(quizId);
        questionNumber = questionsList.get(0).getAnswer_id();
        questions = questionsList.size();
        lastQuestion = questionsList.get(questions-1).getAnswer_id()+1;

        model.addAttribute("description", quizDesc);
        model.addAttribute("image", "Images/" + answersList.findById(questionNumber).get().getImage());
        model.addAttribute("points", "Your current score: " + points + "/" + questions);
        model.addAttribute("language", "Enter your answers in: " + language);

        return "quiz";
    }

    @PostMapping("/nextQuiz")
    public String viewNextQuiz(Model model, @ModelAttribute UserInput userInput, Principal principal){

        String correctAnswer="";
        String input = userInput.getInput();
        String page="";

        model.addAttribute("userInput", new UserInput());

        if(language.equals("English")){
            correctAnswer=answersList.findById(questionNumber).get().getEng_bodyc();
        }
        else if(language.equals("Latinum")){
            correctAnswer=answersList.findById(questionNumber).get().getLat_body();
        }
        else if(language.equals("Polski")){
            correctAnswer=answersList.findById(questionNumber).get().getPol_body();
        }

        if(input.equalsIgnoreCase(correctAnswer))
            points=points+1;

        questionNumber=questionNumber+1L;

        if(questionNumber!=lastQuestion) {
            model.addAttribute("description", quizDesc);
            model.addAttribute("image", "Images/" + answersList.findById(questionNumber).get().getImage());
            model.addAttribute("points", "Your current score: " + points + "/" + questions);
            model.addAttribute("language", "Enter your answers in: " + language);
            page="quiz";
        }
        else {
            int totalPoints = userManager.findByLogin(principal.getName()).getPoints();
            totalPoints=totalPoints+points;
            userManager.updatePoints(principal.getName(), totalPoints);
            model.addAttribute("points", "Your total score: " + points + "/" + questions);
            page="endQuiz";
        }
        return page;
    }
}
