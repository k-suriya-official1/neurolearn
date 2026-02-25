package com.neurolearn.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_progress")
public class UserProgress {

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
    private boolean completed;

    @Column(nullable = false)
    private boolean unlocked;

    // =========================
    // Constructors
    // =========================

    // Default constructor (required by JPA)
    public UserProgress() {
    }

    // All-args constructor
    public UserProgress(Long id, User user, Stage stage, Level level,
                        boolean completed, boolean unlocked) {
        this.id = id;
        this.user = user;
        this.stage = stage;
        this.level = level;
        this.completed = completed;
        this.unlocked = unlocked;
    }

    // Constructor without ID (for creating new progress)
    public UserProgress(User user, Stage stage, Level level,
                        boolean completed, boolean unlocked) {
        this.user = user;
        this.stage = stage;
        this.level = level;
        this.completed = completed;
        this.unlocked = unlocked;
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    // =========================
    // toString()
    // =========================

    @Override
    public String toString() {
        return "UserProgress{" +
                "id=" + id +
                ", user=" + (user != null ? user.getUsername() : null) +
                ", stage=" + (stage != null ? stage.getName() : null) +
                ", level=" + (level != null ? level.getLevelNumber() : null) +
                ", completed=" + completed +
                ", unlocked=" + unlocked +
                '}';
    }
}