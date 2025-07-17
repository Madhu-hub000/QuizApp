package com.college.quizapp.Controller;

import com.college.quizapp.Entity.Question;
import com.college.quizapp.Entity.QuestionWrapper;
import com.college.quizapp.Entity.Response;
import com.college.quizapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id){
        return quizService.getQuiz(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> calculateMarks(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateMarks(id, responses);
    }
}
