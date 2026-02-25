package com.neurolearn.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NeuroType neuroType; // ADHD, AUTISM, DYSLEXIA

    @ManyToOne
    @JoinColumn(name = "stage_id", nullable = false)
    private Stage stage;

    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String questionText;

    // Optional image for the question
    private String imageUrl;

    @Column(nullable = false)
    private String optionA;

    @Column(nullable = false)
    private String optionB;

    @Column(nullable = false)
    private String optionC;

    @Column(nullable = false)
    private String optionD;

    @Column(nullable = false)
    private String correctAnswer; // "A", "B", "C", or "D"

    // =========================
    // Constructors
    // =========================

    // Default Constructor (Required by JPA)
    public Question() {
    }

    // All-Args Constructor
    public Question(Long id, NeuroType neuroType, Stage stage, Level level,
                    String questionText, String imageUrl,
                    String optionA, String optionB,
                    String optionC, String optionD,
                    String correctAnswer) {
        this.id = id;
        this.neuroType = neuroType;
        this.stage = stage;
        this.level = level;
        this.questionText = questionText;
        this.imageUrl = imageUrl;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }

    // Constructor without ID (for creating new questions)
    public Question(NeuroType neuroType, Stage stage, Level level,
                    String questionText, String imageUrl,
                    String optionA, String optionB,
                    String optionC, String optionD,
                    String correctAnswer) {
        this.neuroType = neuroType;
        this.stage = stage;
        this.level = level;
        this.questionText = questionText;
        this.imageUrl = imageUrl;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
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

    public NeuroType getNeuroType() {
        return neuroType;
    }

    public void setNeuroType(NeuroType neuroType) {
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

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    // =========================
    // toString()
    // =========================

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", neuroType=" + neuroType +
                ", stage=" + (stage != null ? stage.getName() : null) +
                ", level=" + (level != null ? level.getLevelNumber() : null) +
                ", questionText='" + questionText + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }

    // =========================
    // Enum
    // =========================

    public enum NeuroType {
        ADHD,
        AUTISM,
        DYSLEXIA
    }
}