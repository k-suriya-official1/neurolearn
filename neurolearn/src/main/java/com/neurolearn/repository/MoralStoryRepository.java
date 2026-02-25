package com.neurolearn.repository;

import com.neurolearn.entity.Level;
import com.neurolearn.entity.MoralStory;
import com.neurolearn.entity.Question.NeuroType;
import com.neurolearn.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoralStoryRepository extends JpaRepository<MoralStory, Long> {
    Optional<MoralStory> findByNeuroTypeAndStageAndLevel(
            NeuroType neuroType, Stage stage, Level level);
}