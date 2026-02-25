package com.neurolearn.controller;

import com.neurolearn.entity.Question;
import com.neurolearn.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // GET /api/questions?neuroType=ADHD&stage=BASIC&level=1
    @GetMapping
    public ResponseEntity<?> getQuestions(
            @RequestParam String neuroType,
            @RequestParam String stage,
            @RequestParam int level,
            @RequestParam Long userId) {  // ← Add userId param
        try {
            return ResponseEntity.ok(questionService.getQuestions(neuroType, stage, level, userId));
        } catch (RuntimeException e) {
            return ResponseEntity.status(403).body(Map.of("error", e.getMessage()));
        }
    }
}