package com.neurolearn.repository;

import com.neurolearn.entity.Level;
import com.neurolearn.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LevelRepository extends JpaRepository<Level, Long> {
    List<Level> findByStage(Stage stage);
    Optional<Level> findByStageAndLevelNumber(Stage stage, int levelNumber);
}