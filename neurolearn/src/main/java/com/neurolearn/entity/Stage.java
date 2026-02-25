package com.neurolearn.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stages")
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private StageName name;

    // Default Constructor
    public Stage() {
    }

    // All-Args Constructor
    public Stage(Long id, StageName name) {
        this.id = id;
        this.name = name;
    }

    // Constructor without ID (useful when creating new Stage)
    public Stage(StageName name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StageName getName() {
        return name;
    }

    public void setName(StageName name) {
        this.name = name;
    }

    // Optional: toString()
    @Override
    public String toString() {
        return "Stage{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    // Enum
    public enum StageName {
        BASIC,
        INTERMEDIATE,
        ADVANCED
    }
}