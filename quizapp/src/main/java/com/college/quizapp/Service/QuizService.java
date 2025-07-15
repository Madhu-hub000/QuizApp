package com.college.quizapp.Service;

import com.college.quizapp.Entity.Question;
import com.college.quizapp.Entity.Quiz;
import com.college.quizapp.dao.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    public ResponseEntity<String> createQuiz(String category, int qNum, String title) {
        List<Question> question = quizDao.findRandomQuestionByCategory(category, qNum);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionList(question);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
