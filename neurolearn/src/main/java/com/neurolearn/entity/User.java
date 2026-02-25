package com.neurolearn.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private int age; // 5-12

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NeuroDiversityType neuroDiversityType; // AUTISM, ADHD, DYSLEXIA

    private String academicBackground;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    // Default Constructor
    public User() {
    }

    // All-Args Constructor
    public User(Long id, String fullName, String gender, int age,
                NeuroDiversityType neuroDiversityType,
                String academicBackground,
                String phoneNumber, String email,
                String username, String password) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.neuroDiversityType = neuroDiversityType;
        this.academicBackground = academicBackground;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public NeuroDiversityType getNeuroDiversityType() {
        return neuroDiversityType;
    }

    public void setNeuroDiversityType(NeuroDiversityType neuroDiversityType) {
        this.neuroDiversityType = neuroDiversityType;
    }

    public String getAcademicBackground() {
        return academicBackground;
    }

    public void setAcademicBackground(String academicBackground) {
        this.academicBackground = academicBackground;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Enum
    public enum NeuroDiversityType {
        AUTISM,
        ADHD,
        DYSLEXIA
    }
}