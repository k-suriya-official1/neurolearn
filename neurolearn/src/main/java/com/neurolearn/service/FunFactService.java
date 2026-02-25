package com.neurolearn.service;

import com.neurolearn.entity.*;
import com.neurolearn.entity.Question.NeuroType;
import com.neurolearn.entity.Stage.StageName;
import com.neurolearn.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunFactService {

    @Autowired private FunFactRepository funFactRepository;
    @Autowired private StageRepository stageRepository;
    @Autowired private LevelRepository levelRepository;

    // Called after every 5 questions → pass questionNumber (5,10,15...)
    public FunFact getFunFact(String neuroType, String stageName,
                               int levelNumber, int questionNumber) {

        Stage stage = stageRepository.findByName(StageName.valueOf(stageName.toUpperCase()))
                .orElseThrow(() -> new RuntimeException("Stage not found"));

        Level level = levelRepository.findByStageAndLevelNumber(stage, levelNumber)
                .orElseThrow(() -> new RuntimeException("Level not found"));

        List<FunFact> facts = funFactRepository
                .findByNeuroTypeAndStageAndLevelOrderByFactOrder(
                        NeuroType.valueOf(neuroType.toUpperCase()), stage, level);

        // factOrder index: Q5→fact1, Q10→fact2, Q15→fact3...
        int index = (questionNumber / 5) - 1;

        if (facts.isEmpty() || index >= facts.size()) {
            throw new RuntimeException("No fun fact found for this position");
        }

        return facts.get(index);
    }
}