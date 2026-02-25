package com.neurolearn.controller;

import com.neurolearn.entity.MoralStory;
import com.neurolearn.service.MoralStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/story")
@CrossOrigin(origins = "*")
public class MoralStoryController {

    @Autowired
    private MoralStoryService moralStoryService;

    // Called after level is completed
    // GET /api/story?neuroType=ADHD&stage=BASIC&level=1
    @GetMapping
    public ResponseEntity<?> getStory(
            @RequestParam String neuroType,
            @RequestParam String stage,
            @RequestParam int level) {
        try {
            MoralStory story = moralStoryService.getStory(neuroType, stage, level);
            return ResponseEntity.ok(story);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(java.util.Map.of("error", e.getMessage()));
        }
    }
}