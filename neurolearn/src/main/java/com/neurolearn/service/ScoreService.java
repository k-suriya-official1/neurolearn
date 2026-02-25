package com.neurolearn.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neurolearn.dto.SubmitAnswerRequest;
import com.neurolearn.entity.Level;
import com.neurolearn.entity.Question;
import com.neurolearn.entity.Score;
import com.neurolearn.entity.Stage;
import com.neurolearn.entity.User;
import com.neurolearn.entity.UserProgress;
import com.neurolearn.repository.LevelRepository;
import com.neurolearn.repository.QuestionRepository;
import com.neurolearn.repository.ScoreRepository;
import com.neurolearn.repository.StageRepository;
import com.neurolearn.repository.UserProgressRepository;
import com.neurolearn.repository.UserRepository;

@Service
public class ScoreService {

    private static final int PASS_SCORE = 30;

    @Autowired private UserRepository userRepository;
    @Autowired private StageRepository stageRepository;
    @Autowired private LevelRepository levelRepository;
    @Autowired private QuestionRepository questionRepository;
    @Autowired private ScoreRepository scoreRepository;
    @Autowired private UserProgressRepository userProgressRepository;

    public Map<String, Object> submitAnswers(SubmitAnswerRequest request) {

        Map<String, Object> response = new HashMap<>();

        // Fetch user
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Fetch stage
        Stage stage = stageRepository
                .findByName(Stage.StageName.valueOf(request.getStage().toUpperCase()))
                .orElseThrow(() -> new RuntimeException("Stage not found"));

        // Fetch level
        Level level = levelRepository
                .findByStageAndLevelNumber(stage, request.getLevelNumber())
                .orElseThrow(() -> new RuntimeException("Level not found"));

        // Calculate score
        Map<Long, String> answers = request.getAnswers();
        int score = 0;

        for (Map.Entry<Long, String> entry : answers.entrySet()) {
            Question question = questionRepository.findById(entry.getKey()).orElse(null);

            if (question != null &&
                    question.getCorrectAnswer().equalsIgnoreCase(entry.getValue())) {
                score++;
            }
        }

        boolean passed = score >= PASS_SCORE;

        // ✅ SAVE SCORE (NO BUILDER)
        Score scoreEntity = new Score(
                user,
                stage,
                level,
                score,
                passed,
                LocalDateTime.now()
        );

        scoreRepository.save(scoreEntity);

        // ✅ UPDATE PROGRESS (NO BUILDER)
        UserProgress progress = userProgressRepository
                .findByUserAndStageAndLevel(user, stage, level)
                .orElse(null);

        if (progress == null) {
            progress = new UserProgress(user, stage, level, passed, true);
        } else {
            progress.setCompleted(passed);
        }

        userProgressRepository.save(progress);

        // Unlock next if passed
        if (passed) {
            unlockNextLevel(user, stage, level);
        }

        response.put("score", score);
        response.put("passed", passed);
        response.put("message",
                passed ? "🎉 Level Passed! Next level unlocked!"
                       : "❌ Score below 30. Try again!");

        return response;
    }

    // =========================================
    // UNLOCK NEXT LEVEL
    // =========================================

    private void unlockNextLevel(User user, Stage stage, Level currentLevel) {

        int nextLevelNumber = currentLevel.getLevelNumber() + 1;

        if (nextLevelNumber <= 3) {

            levelRepository
                    .findByStageAndLevelNumber(stage, nextLevelNumber)
                    .ifPresent(nextLevel -> {

                        UserProgress next = userProgressRepository
                                .findByUserAndStageAndLevel(user, stage, nextLevel)
                                .orElse(null);

                        if (next == null) {
                            next = new UserProgress(user, stage, nextLevel, false, true);
                        } else {
                            next.setUnlocked(true);
                        }

                        userProgressRepository.save(next);
                    });

        } else {
            unlockNextStage(user, stage);
        }
    }

    // =========================================
    // UNLOCK NEXT STAGE
    // =========================================

    private void unlockNextStage(User user, Stage currentStage) {

        Stage.StageName nextStageName = null;

        if (currentStage.getName() == Stage.StageName.BASIC)
            nextStageName = Stage.StageName.INTERMEDIATE;

        else if (currentStage.getName() == Stage.StageName.INTERMEDIATE)
            nextStageName = Stage.StageName.ADVANCED;

        if (nextStageName != null) {

            stageRepository.findByName(nextStageName).ifPresent(nextStage -> {

                levelRepository.findByStageAndLevelNumber(nextStage, 1)
                        .ifPresent(firstLevel -> {

                            UserProgress progress = userProgressRepository
                                    .findByUserAndStageAndLevel(user, nextStage, firstLevel)
                                    .orElse(null);

                            if (progress == null) {
                                progress = new UserProgress(user, nextStage, firstLevel, false, true);
                            } else {
                                progress.setUnlocked(true);
                            }

                            userProgressRepository.save(progress);
                        });
            });
        }
    }
}