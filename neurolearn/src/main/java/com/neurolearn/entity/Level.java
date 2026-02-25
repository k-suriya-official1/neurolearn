package com.neurolearn.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "levels")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stage_id", nullable = false)
    private Stage stage;

    @Column(nullable = false)
    private int levelNumber; // 1, 2, or 3

    @Column(nullable = false)
    private String difficulty; // Easy, Medium, Hard

    // Default Constructor
    public Level() {
    }

    // All-Args Constructor
    public Level(Long id, Stage stage, int levelNumber, String difficulty) {
        this.id = id;
        this.stage = stage;
        this.levelNumber = levelNumber;
        this.difficulty = difficulty;
    }

    // Constructor without ID (useful when creating new Level)
    public Level(Stage stage, int levelNumber, String difficulty) {
        this.stage = stage;
        this.levelNumber = levelNumber;
        this.difficulty = difficulty;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    // Optional: toString()
    @Override
    public String toString() {
        return "Level{" +
                "id=" + id +
                ", stage=" + (stage != null ? stage.getName() : null) +
                ", levelNumber=" + levelNumber +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}