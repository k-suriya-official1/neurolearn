package com.neurolearn.initializer;

import com.neurolearn.entity.Level;
import com.neurolearn.entity.MoralStory;
import com.neurolearn.entity.Question.NeuroType;
import com.neurolearn.entity.Stage;
import com.neurolearn.entity.Stage.StageName;
import com.neurolearn.repository.LevelRepository;
import com.neurolearn.repository.MoralStoryRepository;
import com.neurolearn.repository.StageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class ADHDBasicLevel1MoralStoryInitializer {

    @Bean
    @Order(20) // After fun fact initializers
    CommandLineRunner initADHDBasicLevel1Story(
            MoralStoryRepository moralStoryRepository,
            StageRepository stageRepository,
            LevelRepository levelRepository) {

        return args -> {

            Stage basic = stageRepository.findByName(StageName.BASIC)
                    .orElseThrow(() -> new RuntimeException("BASIC stage not found"));

            Level level1 = levelRepository.findByStageAndLevelNumber(basic, 1)
                    .orElseThrow(() -> new RuntimeException("Level 1 not found"));

            if (moralStoryRepository
                    .findByNeuroTypeAndStageAndLevel(
                            NeuroType.ADHD, basic, level1)
                    .isPresent()) {

                System.out.println("✅ ADHD Basic Level 1 Moral Story already exists. Skipping...");
                return;
            }

            MoralStory story = new MoralStory(
                    NeuroType.ADHD,
                    basic,
                    level1,
                    "The Honest Rabbit",
                    "A little rabbit was hopping on the path. " +
                    "He saw a shiny orange carrot on the ground. " +
                    "The carrot looked fresh and tasty. " +
                    "But the rabbit knew it was not his. " +
                    "He looked left and right to find the owner. " +
                    "He asked the bird sitting on the tree. " +
                    "The bird chirped, It is not mine! " +
                    "Then he asked the squirrel near the bush. " +
                    "The squirrel said, Not mine, dear rabbit! " +
                    "Soon he saw a slow turtle walking. " +
                    "The turtle looked worried and searching. " +
                    "The rabbit asked, Did you lose a carrot? " +
                    "The turtle smiled and said yes. " +
                    "The rabbit happily gave the carrot back. " +
                    "The turtle thanked him with a big smile. " +
                    "They both felt very happy inside.",
                    "Always be honest."
            );

            moralStoryRepository.save(story);

            System.out.println("✅ ADHD Basic Level 1 Moral Story inserted successfully!");
        };
    }
}