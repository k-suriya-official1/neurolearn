package com.neurolearn.repository;

import com.neurolearn.entity.Stage;
import com.neurolearn.entity.Stage.StageName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StageRepository extends JpaRepository<Stage, Long> {
    Optional<Stage> findByName(StageName name);
}