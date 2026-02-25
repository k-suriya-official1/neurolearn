package com.neurolearn.initializer;

import com.neurolearn.entity.FunFact;
import com.neurolearn.entity.Level;
import com.neurolearn.entity.Question.NeuroType;
import com.neurolearn.entity.Stage;
import com.neurolearn.entity.Stage.StageName;
import com.neurolearn.repository.FunFactRepository;
import com.neurolearn.repository.LevelRepository;
import com.neurolearn.repository.StageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ADHDBasicLevel1FunFactInitializer {

    @Bean
    @Order(11) // After question initializers
    CommandLineRunner initADHDBasicLevel1FunFacts(
            FunFactRepository funFactRepository,
            StageRepository stageRepository,
            LevelRepository levelRepository) {

        return args -> {

            Stage basic = stageRepository.findByName(StageName.BASIC)
                    .orElseThrow(() -> new RuntimeException("BASIC stage not found"));

            Level level1 = levelRepository.findByStageAndLevelNumber(basic, 1)
                    .orElseThrow(() -> new RuntimeException("Level 1 not found"));

            if (!funFactRepository
                    .findByNeuroTypeAndStageAndLevelOrderByFactOrder(
                            NeuroType.ADHD, basic, level1)
                    .isEmpty()) {

                System.out.println("✅ ADHD Basic Level 1 Fun Facts already exist. Skipping...");
                return;
            }

            List<FunFact> facts = new ArrayList<>();

            facts.add(new FunFact(NeuroType.ADHD, basic, level1,
                    "🐱 Cats use their whiskers to help measure spaces and move safely.", 1));

            facts.add(new FunFact(NeuroType.ADHD, basic, level1,
                    "🌞 The Sun gives us light and warmth every day.", 2));

            facts.add(new FunFact(NeuroType.ADHD, basic, level1,
                    "🐠 Fish breathe underwater using special organs called gills.", 3));

            facts.add(new FunFact(NeuroType.ADHD, basic, level1,
                    "🌈 Rainbows appear when sunlight shines through raindrops.", 4));

            facts.add(new FunFact(NeuroType.ADHD, basic, level1,
                    "🐶 Dogs have a very strong sense of smell compared to humans.", 5));

            facts.add(new FunFact(NeuroType.ADHD, basic, level1,
                    "🌙 The Moon shines because it reflects light from the Sun.", 6));

            facts.add(new FunFact(NeuroType.ADHD, basic, level1,
                    "🌳 Plants make their own food using sunlight, air, and water.", 7));

            facts.add(new FunFact(NeuroType.ADHD, basic, level1,
                    "🦋 Butterflies start their life as caterpillars before growing wings.", 8));

            facts.add(new FunFact(NeuroType.ADHD, basic, level1,
                    "🚗 Wheels help vehicles move smoothly and quickly.", 9));

            facts.add(new FunFact(NeuroType.ADHD, basic, level1,
                    "🧠 Learning something new helps your brain grow stronger.", 10));

            funFactRepository.saveAll(facts);

            System.out.println("✅ ADHD Basic Level 1 Fun Facts inserted successfully!");
        };
    }
}