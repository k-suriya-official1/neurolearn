package com.neurolearn.controller;

import com.neurolearn.dto.SubmitAnswerRequest;
import com.neurolearn.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/score")
@CrossOrigin(origins = "*")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/submit")
    public ResponseEntity<Map<String, Object>> submit(@RequestBody SubmitAnswerRequest request) {
        return ResponseEntity.ok(scoreService.submitAnswers(request));
    }
}