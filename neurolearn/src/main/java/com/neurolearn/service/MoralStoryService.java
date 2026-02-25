package com.neurolearn.service;

import com.neurolearn.entity.*;
import com.neurolearn.entity.Question.NeuroType;
import com.neurolearn.entity.Stage.StageName;
import com.neurolearn.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoralStoryService {

    @Autowired private MoralStoryRepository moralStoryRepository;
    @Autowired private StageRepository stageRepository;
    @Autowired private LevelRepository levelRepository;

    // Called after level is completed
    public MoralStory getStory(String neuroType, String stageName, int levelNumber) {

        Stage stage = stageRepository.findByName(StageName.valueOf(stageName.toUpperCase()))
                .orElseThrow(() -> new RuntimeException("Stage not found"));

        Level level = levelRepository.findByStageAndLevelNumber(stage, levelNumber)
                .orElseThrow(() -> new RuntimeException("Level not found"));

        return moralStoryRepository
                .findByNeuroTypeAndStageAndLevel(
                        NeuroType.valueOf(neuroType.toUpperCase()), stage, level)
                .orElseThrow(() -> new RuntimeException("Story not found"));
    }
}