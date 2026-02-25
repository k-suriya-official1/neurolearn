package com.neurolearn.service;

import com.neurolearn.entity.Level;
import com.neurolearn.entity.Question;
import com.neurolearn.entity.Question.NeuroType;
import com.neurolearn.entity.Stage;
import com.neurolearn.entity.Stage.StageName;
import com.neurolearn.entity.User;
import com.neurolearn.entity.UserProgress;
import com.neurolearn.repository.LevelRepository;
import com.neurolearn.repository.QuestionRepository;
import com.neurolearn.repository.StageRepository;
import com.neurolearn.repository.UserProgressRepository;
import com.neurolearn.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private StageRepository stageRepository;

    @Autowired
    private LevelRepository levelRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserProgressRepository userProgressRepository;

    public List<Question> getQuestions(String neuroType, String stageName, int levelNumber, Long userId) {

        Stage stage = stageRepository.findByName(StageName.valueOf(stageName.toUpperCase()))
                .orElseThrow(() -> new RuntimeException("Stage not found: " + stageName));

        Level level = levelRepository.findByStageAndLevelNumber(stage, levelNumber)
                .orElseThrow(() -> new RuntimeException("Level not found: " + levelNumber));

        // ✅ Check if user has unlocked this level
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserProgress progress = userProgressRepository
                .findByUserAndStageAndLevel(user, stage, level)
                .orElseThrow(() -> new RuntimeException("🔒 Level not unlocked yet! Complete previous level first."));

        if (!progress.isUnlocked()) {
            throw new RuntimeException("🔒 Level not unlocked yet! Complete previous level first.");
        }

        return questionRepository.findByNeuroTypeAndStageAndLevel(
                NeuroType.valueOf(neuroType.toUpperCase()), stage, level);
    }
}