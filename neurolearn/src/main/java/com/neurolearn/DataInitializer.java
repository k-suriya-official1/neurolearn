package com.neurolearn;

import com.neurolearn.entity.Level;
import com.neurolearn.entity.Stage;
import com.neurolearn.entity.Stage.StageName;
import com.neurolearn.repository.LevelRepository;
import com.neurolearn.repository.StageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class DataInitializer {

    @Bean
    @Order(1)
    public CommandLineRunner initData(StageRepository stageRepository,
                                      LevelRepository levelRepository) {

        return args -> {

            // Prevent duplicate insert on restart
            if (stageRepository.count() > 0) {
                System.out.println("✅ Data already initialized. Skipping...");
                return;
            }

            // =========================
            // BASIC STAGE
            // =========================
            Stage basic = new Stage(StageName.BASIC);
            basic = stageRepository.save(basic);

            levelRepository.save(new Level(basic, 1, "Easy"));
            levelRepository.save(new Level(basic, 2, "Medium"));
            levelRepository.save(new Level(basic, 3, "Hard"));

            // =========================
            // INTERMEDIATE STAGE
            // =========================
            Stage intermediate = new Stage(StageName.INTERMEDIATE);
            intermediate = stageRepository.save(intermediate);

            levelRepository.save(new Level(intermediate, 1, "Easy"));
            levelRepository.save(new Level(intermediate, 2, "Medium"));
            levelRepository.save(new Level(intermediate, 3, "Hard"));

            // =========================
            // ADVANCED STAGE
            // =========================
            Stage advanced = new Stage(StageName.ADVANCED);
            advanced = stageRepository.save(advanced);

            levelRepository.save(new Level(advanced, 1, "Easy"));
            levelRepository.save(new Level(advanced, 2, "Medium"));
            levelRepository.save(new Level(advanced, 3, "Hard"));

            System.out.println("✅ Stages and Levels initialized successfully!");
        };
    }
}