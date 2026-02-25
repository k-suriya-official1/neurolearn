package com.neurolearn.controller;

import com.neurolearn.entity.FunFact;
import com.neurolearn.service.FunFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/funfact")
@CrossOrigin(origins = "*")
public class FunFactController {

    @Autowired
    private FunFactService funFactService;

    // Called after every 5 questions
    // GET /api/funfact?neuroType=ADHD&stage=BASIC&level=1&questionNumber=5
    @GetMapping
    public ResponseEntity<?> getFunFact(
            @RequestParam String neuroType,
            @RequestParam String stage,
            @RequestParam int level,
            @RequestParam int questionNumber) {
        try {
            FunFact fact = funFactService.getFunFact(neuroType, stage, level, questionNumber);
            return ResponseEntity.ok(fact);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(java.util.Map.of("error", e.getMessage()));
        }
    }
}