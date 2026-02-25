package com.neurolearn.dto;

import java.util.Map;

public class SubmitAnswerRequest {

    private Long userId;
    private String stage;       // BASIC, INTERMEDIATE, ADVANCED
    private int levelNumber;    // 1, 2, 3

    // Map of questionId → user's answer ("A", "B", "C", "D")
    private Map<Long, String> answers;

    // =========================
    // Constructors
    // =========================

    public SubmitAnswerRequest() {
    }

    public SubmitAnswerRequest(Long userId, String stage, int levelNumber,
                               Map<Long, String> answers) {
        this.userId = userId;
        this.stage = stage;
        this.levelNumber = levelNumber;
        this.answers = answers;
    }

    // =========================
    // Getters and Setters
    // =========================

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public Map<Long, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Long, String> answers) {
        this.answers = answers;
    }

    // =========================
    // toString()
    // =========================

    @Override
    public String toString() {
        return "SubmitAnswerRequest{" +
                "userId=" + userId +
                ", stage='" + stage + '\'' +
                ", levelNumber=" + levelNumber +
                ", answers=" + answers +
                '}';
    }
}