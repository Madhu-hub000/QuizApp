package com.college.quizapp.Service;

import com.college.quizapp.Entity.Question;
import com.college.quizapp.Entity.QuestionWrapper;
import com.college.quizapp.Entity.Quiz;
import com.college.quizapp.Entity.Response;
import com.college.quizapp.dao.QuestionDao;
import com.college.quizapp.dao.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;
    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int qNum, String title) {
        List<Question> question = questionDao.findRandomQuestionByCategory(category, qNum);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionList(question);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionFromDB = quiz.get().getQuestionList();
        List<QuestionWrapper> questionFromUser = new ArrayList<>();
        for (Question q : questionFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestion(), q.getOption1(), q.getOption2(), q.getOption3());
            questionFromUser.add(qw);
        }
        return new ResponseEntity<>(questionFromUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateMarks(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionFromDB = quiz.get().getQuestionList();
        int right = 0;
        int i = 0;
        for (Question q : questionFromDB){
            if(q.getAnswer().equals(responses.get(i).getResponses())) {
                right++;
                i++;
            }
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
