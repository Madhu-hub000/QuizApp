package com.college.quizapp.dao;

import com.college.quizapp.Entity.Question;
import com.college.quizapp.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {
    @Query(value = "SELECT * FROM question q where q.category=:category ORDER BY RANDOM() LIMIT :qNum", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int qNum);
}
