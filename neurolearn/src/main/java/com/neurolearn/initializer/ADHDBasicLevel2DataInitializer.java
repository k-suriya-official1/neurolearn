package com.neurolearn.initializer;

import com.neurolearn.entity.Level;
import com.neurolearn.entity.Question;
import com.neurolearn.entity.Question.NeuroType;
import com.neurolearn.entity.Stage;
import com.neurolearn.entity.Stage.StageName;
import com.neurolearn.repository.LevelRepository;
import com.neurolearn.repository.QuestionRepository;
import com.neurolearn.repository.StageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ADHDBasicLevel2DataInitializer {

    @Bean
    @Order(3)
    CommandLineRunner initADHDBasicLevel2(
            QuestionRepository questionRepository,
            StageRepository stageRepository,
            LevelRepository levelRepository) {

        return args -> {

            Stage basic = stageRepository.findByName(StageName.BASIC)
                    .orElseThrow(() -> new RuntimeException("BASIC stage not found"));

            Level level2 = levelRepository.findByStageAndLevelNumber(basic, 2)
                    .orElseThrow(() -> new RuntimeException("Level 2 not found"));

            if (!questionRepository
                    .findByNeuroTypeAndStageAndLevel(NeuroType.ADHD, basic, level2)
                    .isEmpty()) {
                System.out.println("✅ ADHD Basic Level 2 questions already exist. Skipping...");
                return;
            }

            List<Question> questions = new ArrayList<>();

            // ============================
            // 20 DIFFERENT QUESTIONS
            // ============================

            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Onion","Apple","Banana","Grapes","A"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Mango","Carrot","Potato","Brinjal","A"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Dog","Table","Cat","Tiger","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Rose","Shoe","Lily","Lotus","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Banana","Shirt","Pants","Cap","A"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Bus","Pencil","Train","Car","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Chair","Milk","Juice","Water","A"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Lion","Tiger","Book","Elephant","C"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Carrot","Apple","Mango","Banana","A"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Table","Orange","Chair","Bed","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Pen","Dog","Pencil","Eraser","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Spoon","Cow","Goat","Hen","A"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Red","Blue","Apple","Green","C"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Sun","Moon","Shoe","Star","C"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Potato","Mango","Tomato","Onion","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Bike","Banana","Bus","Cycle","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Cake","Book","Chocolate","Candy","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Dog","Car","Cat","Rabbit","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Shirt","Mango","Cap","Shoes","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level2,"Which is different?",null,"Fish","Shark","Tree","Whale","C"));

            // ============================
            // 30 BEHAVIOR QUESTIONS
            // ============================

            questions.add(new Question(NeuroType.ADHD,basic,level2,"Before eating, what should you do?",null,"Run","Wash hands","Jump","Sleep","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"When teacher speaks, you should",null,"Shout","Dance","Listen","Run","C"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"At the library, you must",null,"Run","Be quiet","Jump","Sing loudly","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"If your friend falls, you should",null,"Ignore","Help","Walk away","Laugh","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"Trash should go into",null,"Road","Dustbin","Floor","Desk","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"Before sleeping, you should",null,"Jump","Brush teeth","Shout","Play loudly","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"When crossing road, you must",null,"Close eyes","Look both sides","Run fast","Jump","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"In classroom you should",null,"Fight","Sit properly","Throw things","Shout","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"If someone is talking, you should",null,"Interrupt","Leave","Wait your turn","Shout","C"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"After playing outside, you should",null,"Sleep","Wash hands","Hide","Cry","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"When you feel angry, you should",null,"Hit","Take deep breath","Throw","Shout","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"During online class you must",null,"Sleep","Play games","Pay attention","Walk away","C"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"If floor is wet, you should",null,"Run","Slide","Walk carefully","Jump","C"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"When someone helps you, say",null,"Nothing","Thank you","No","Go away","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"Before answering, you should",null,"Run","Raise hand","Shout","Stand","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"If you don't understand, you should",null,"Ignore","Ask teacher","Leave","Cry","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"Books should be kept",null,"On floor","On shelf","Outside","Under bed","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"While eating, you should",null,"Jump","Sit calmly","Run","Shout","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"If classroom is dirty, you should",null,"Leave","Clean it","Throw more","Ignore","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"When alarm rings in school, you should",null,"Hide","Follow teacher","Run randomly","Shout","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"When friend shares toys, you should",null,"Fight","Share back","Hide","Take all","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"During group work, you should",null,"Sleep","Cooperate","Fight","Ignore","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"If you make a mistake, you should",null,"Quit","Try again","Hide","Cry","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"When waiting in line, you should",null,"Push","Stand patiently","Run","Shout","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"In playground you must",null,"Fight","Throw stones","Play safely","Push others","C"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"If you finish work early, you should",null,"Disturb others","Stay quiet","Run","Shout","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"When lights go off, you should",null,"Panic","Stay calm","Cry","Run","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"If someone is sad, you should",null,"Laugh","Comfort them","Leave","Ignore","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"During exam you must",null,"Talk","Focus","Copy","Walk","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level2,"After using toys, you should",null,"Hide","Keep back","Throw","Leave","B"));

            questionRepository.saveAll(questions);

            System.out.println("✅ ADHD Basic Level 2 — 50 questions inserted successfully!");
        };
    }
}