package com.neurolearn.repository;

import com.neurolearn.entity.Level;
import com.neurolearn.entity.Score;
import com.neurolearn.entity.Stage;
import com.neurolearn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByUser(User user);
    Optional<Score> findByUserAndStageAndLevel(User user, Stage stage, Level level);
}