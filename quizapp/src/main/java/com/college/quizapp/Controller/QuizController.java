package com.college.quizapp.Controller;

import com.college.quizapp.Entity.Question;
import com.college.quizapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("create/{category}/{qNum}/{title}")
    public ResponseEntity<String> createQuiz(@PathVariable String category, @PathVariable int qNum, @PathVariable String title){
        return quizService.createQuiz(category, qNum, title);
    }
}
