package com.neurolearn.repository;

import com.neurolearn.entity.FunFact;
import com.neurolearn.entity.Level;
import com.neurolearn.entity.Question.NeuroType;
import com.neurolearn.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FunFactRepository extends JpaRepository<FunFact, Long> {
    List<FunFact> findByNeuroTypeAndStageAndLevelOrderByFactOrder(
            NeuroType neuroType, Stage stage, Level level);
}