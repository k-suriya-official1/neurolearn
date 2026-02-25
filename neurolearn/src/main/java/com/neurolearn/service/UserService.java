package com.neurolearn.service;

import com.neurolearn.dto.LoginRequest;
import com.neurolearn.dto.RegisterRequest;
import com.neurolearn.entity.Level;
import com.neurolearn.entity.Stage;
import com.neurolearn.entity.Stage.StageName;
import com.neurolearn.entity.User;
import com.neurolearn.entity.UserProgress;
import com.neurolearn.repository.LevelRepository;
import com.neurolearn.repository.StageRepository;
import com.neurolearn.repository.UserProgressRepository;
import com.neurolearn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired 
    private StageRepository stageRepository;
    @Autowired 
    private LevelRepository levelRepository;
    @Autowired 
    private UserProgressRepository userProgressRepository;

    public Map<String, Object> register(RegisterRequest request) {
        Map<String, Object> response = new HashMap<>();

        // Validation checks
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            response.put("success", false);
            response.put("message", "Passwords do not match");
            return response;
        }

        if (userRepository.existsByUsername(request.getUsername())) {
            response.put("success", false);
            response.put("message", "Username already taken");
            return response;
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            response.put("success", false);
            response.put("message", "Email already registered");
            return response;
        }

        if (userRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            response.put("success", false);
            response.put("message", "Phone number already registered");
            return response;
        }

        // Build and save user
        // ⚠️ NOTE: In production, hash the password using BCrypt!
        User user = new User();

        user.setFullName(request.getFullName());
        user.setGender(request.getGender());
        user.setAge(request.getAge());
        user.setNeuroDiversityType(request.getNeuroDiversityType());
        user.setAcademicBackground(request.getAcademicBackground());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        userRepository.save(user);
        initializeUserProgress(user);

        response.put("success", true);
        response.put("message", "Account created successfully!");
        response.put("userId", user.getId());
        response.put("neuroDiversityType", user.getNeuroDiversityType());
        return response;
    }

    public Map<String, Object> login(LoginRequest request) {
        Map<String, Object> response = new HashMap<>();

        User user = userRepository.findByUsername(request.getUsername())
                .orElse(null);

        if (user == null) {
            response.put("success", false);
            response.put("message", "User not found");
            return response;
        }

        // ⚠️ In production, use BCrypt.matches() for password check
        if (!user.getPassword().equals(request.getPassword())) {
            response.put("success", false);
            response.put("message", "Invalid password");
            return response;
        }

        response.put("success", true);
        response.put("message", "Login successful");
        response.put("userId", user.getId());
        response.put("fullName", user.getFullName());
        response.put("neuroDiversityType", user.getNeuroDiversityType());
        return response;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
    private void initializeUserProgress(User user) {

        Stage basic = stageRepository.findByName(StageName.BASIC).orElse(null);
        
        if (basic == null) return;

        Level level1 = levelRepository.findByStageAndLevelNumber(basic, 1).orElse(null);
        if (level1 == null) return;

        // Only Level 1 of BASIC is unlocked at start
        UserProgress progress = new UserProgress();
        progress.setUser(user);
        progress.setStage(basic);
        progress.setLevel(level1);
        progress.setUnlocked(true);
        progress.setCompleted(false);

        userProgressRepository.save(progress);

        System.out.println("✅ Level 1 unlocked for new user: " + user.getUsername());
    }
}