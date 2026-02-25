package com.neurolearn.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "moral_stories")
public class MoralStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Question.NeuroType neuroType;

    @ManyToOne
    @JoinColumn(name = "stage_id")
    private Stage stage;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String storyText;

    private String moral;

    // ✅ Default Constructor (Required by JPA)
    public MoralStory() {
    }

    // ✅ Constructor without ID (Recommended for saving new stories)
    public MoralStory(Question.NeuroType neuroType,
                      Stage stage,
                      Level level,
                      String title,
                      String storyText,
                      String moral) {

        this.neuroType = neuroType;
        this.stage = stage;
        this.level = level;
        this.title = title;
        this.storyText = storyText;
        this.moral = moral;
    }

    // ✅ Full Constructor
    public MoralStory(Long id,
                      Question.NeuroType neuroType,
                      Stage stage,
                      Level level,
                      String title,
                      String storyText,
                      String moral) {

        this.id = id;
        this.neuroType = neuroType;
        this.stage = stage;
        this.level = level;
        this.title = title;
        this.storyText = storyText;
        this.moral = moral;
    }

    // =========================
    // Getters and Setters
    // =========================

    public Long getId() {
        return id;
    }

    public Question.NeuroType getNeuroType() {
        return neuroType;
    }

    public void setNeuroType(Question.NeuroType neuroType) {
        this.neuroType = neuroType;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStoryText() {
        return storyText;
    }

    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }

    public String getMoral() {
        return moral;
    }

    public void setMoral(String moral) {
        this.moral = moral;
    }
}