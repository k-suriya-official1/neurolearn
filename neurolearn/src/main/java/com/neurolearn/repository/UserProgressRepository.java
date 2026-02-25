package com.neurolearn.repository;

import com.neurolearn.entity.Level;
import com.neurolearn.entity.Stage;
import com.neurolearn.entity.User;
import com.neurolearn.entity.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserProgressRepository extends JpaRepository<UserProgress, Long> {
    List<UserProgress> findByUser(User user);
    Optional<UserProgress> findByUserAndStageAndLevel(User user, Stage stage, Level level);
}