package com.neurolearn.controller;

import com.neurolearn.entity.*;
import com.neurolearn.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    @Autowired private UserRepository userRepository;
    @Autowired private ScoreRepository scoreRepository;
    @Autowired private UserProgressRepository userProgressRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getDashboard(@PathVariable Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Score> scores = scoreRepository.findByUser(user);
        List<UserProgress> progressList = userProgressRepository.findByUser(user);

        // Build scores summary
        List<Map<String, Object>> scoreSummary = new ArrayList<>();
        for (Score score : scores) {
            Map<String, Object> s = new LinkedHashMap<>();
            s.put("stage", score.getStage().getName());
            s.put("level", score.getLevel().getLevelNumber());
            s.put("score", score.getTotalScore());
            s.put("passed", score.isPassed());
            s.put("attemptedAt", score.getAttemptedAt());
            scoreSummary.add(s);
        }

        // Build progress summary
        List<Map<String, Object>> progressSummary = new ArrayList<>();
        for (UserProgress p : progressList) {
            Map<String, Object> pr = new LinkedHashMap<>();
            pr.put("stage", p.getStage().getName());
            pr.put("level", p.getLevel().getLevelNumber());
            pr.put("unlocked", p.isUnlocked());
            pr.put("completed", p.isCompleted());
            progressSummary.add(pr);
        }

        // Find current active level (unlocked but not completed)
        String currentStage = "BASIC";
        int currentLevel = 1;
        for (UserProgress p : progressList) {
            if (p.isUnlocked() && !p.isCompleted()) {
                currentStage = p.getStage().getName().toString();
                currentLevel = p.getLevel().getLevelNumber();
                break;
            }
        }

        // Build full dashboard response
        Map<String, Object> dashboard = new LinkedHashMap<>();
        dashboard.put("userId", user.getId());
        dashboard.put("fullName", user.getFullName());
        dashboard.put("neuroDiversityType", user.getNeuroDiversityType());
        dashboard.put("age", user.getAge());
        dashboard.put("currentStage", currentStage);
        dashboard.put("currentLevel", currentLevel);
        dashboard.put("scores", scoreSummary);
        dashboard.put("progress", progressSummary);
        dashboard.put("continuelearning", Map.of(
                "stage", currentStage,
                "level", currentLevel,
                "message", "Keep going! You're doing great! 🚀"
        ));

        return ResponseEntity.ok(dashboard);
    }
}