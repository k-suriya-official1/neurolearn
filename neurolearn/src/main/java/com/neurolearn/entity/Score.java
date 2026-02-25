package com.neurolearn.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "stage_id", nullable = false)
    private Stage stage;

    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;

    @Column(nullable = false)
    private int totalScore;

    @Column(nullable = false)
    private boolean passed; // true if score >= 30

    private LocalDateTime attemptedAt;

    // =========================
    // Constructors
    // =========================

    // Default constructor (required by JPA)
    public Score() {
    }

    // All-args constructor
    public Score(Long id, User user, Stage stage, Level level,
                 int totalScore, boolean passed, LocalDateTime attemptedAt) {
        this.id = id;
        this.user = user;
        this.stage = stage;
        this.level = level;
        this.totalScore = totalScore;
        this.passed = passed;
        this.attemptedAt = attemptedAt;
    }

    // Constructor without ID (for creating new Score)
    public Score(User user, Stage stage, Level level,
                 int totalScore, boolean passed, LocalDateTime attemptedAt) {
        this.user = user;
        this.stage = stage;
        this.level = level;
        this.totalScore = totalScore;
        this.passed = passed;
        this.attemptedAt = attemptedAt;
    }

    // =========================
    // Getters and Setters
    // =========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public LocalDateTime getAttemptedAt() {
        return attemptedAt;
    }

    public void setAttemptedAt(LocalDateTime attemptedAt) {
        this.attemptedAt = attemptedAt;
    }

    // =========================
    // toString()
    // =========================

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", user=" + (user != null ? user.getUsername() : null) +
                ", stage=" + (stage != null ? stage.getName() : null) +
                ", level=" + (level != null ? level.getLevelNumber() : null) +
                ", totalScore=" + totalScore +
                ", passed=" + passed +
                ", attemptedAt=" + attemptedAt +
                '}';
    }
}