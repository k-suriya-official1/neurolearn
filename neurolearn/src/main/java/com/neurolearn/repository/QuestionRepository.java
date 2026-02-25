package com.neurolearn.repository;

import com.neurolearn.entity.Level;
import com.neurolearn.entity.Question;
import com.neurolearn.entity.Question.NeuroType;
import com.neurolearn.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByNeuroTypeAndStageAndLevel(NeuroType neuroType, Stage stage, Level level);
}