package com.neurolearn.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fun_facts")
public class FunFact {

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

    @Column(columnDefinition = "TEXT")
    private String factText;

    private int factOrder; // 1-10 (shown after Q5, Q10, Q15...)

    // ✅ Default Constructor
    public FunFact() {
    }

    // ✅ Constructor without ID (recommended for saving new records)
    public FunFact(Question.NeuroType neuroType, Stage stage, Level level,
                   String factText, int factOrder) {
        this.neuroType = neuroType;
        this.stage = stage;
        this.level = level;
        this.factText = factText;
        this.factOrder = factOrder;
    }

    // ✅ Full Constructor
    public FunFact(Long id, Question.NeuroType neuroType, Stage stage,
                   Level level, String factText, int factOrder) {
        this.id = id;
        this.neuroType = neuroType;
        this.stage = stage;
        this.level = level;
        this.factText = factText;
        this.factOrder = factOrder;
    }

    // ✅ Getters & Setters

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

    public String getFactText() {
        return factText;
    }

    public void setFactText(String factText) {
        this.factText = factText;
    }

    public int getFactOrder() {
        return factOrder;
    }

    public void setFactOrder(int factOrder) {
        this.factOrder = factOrder;
    }
}