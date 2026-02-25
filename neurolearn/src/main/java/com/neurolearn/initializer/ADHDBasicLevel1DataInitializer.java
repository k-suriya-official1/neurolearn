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
public class ADHDBasicLevel1DataInitializer {

    @Bean
    @Order(2)
    CommandLineRunner initADHDBasicLevel1(
            QuestionRepository questionRepository,
            StageRepository stageRepository,
            LevelRepository levelRepository) {

        return args -> {

            Stage basic = stageRepository.findByName(StageName.BASIC)
                    .orElseThrow(() -> new RuntimeException("BASIC stage not found"));

            Level level1 = levelRepository.findByStageAndLevelNumber(basic, 1)
                    .orElseThrow(() -> new RuntimeException("Level 1 not found"));

            if (!questionRepository
                    .findByNeuroTypeAndStageAndLevel(NeuroType.ADHD, basic, level1)
                    .isEmpty()) {
                System.out.println("✅ ADHD Basic Level 1 questions already exist. Skipping...");
                return;
            }

            List<Question> questions = new ArrayList<>();

            // ============================
            // 25 TEXT QUESTIONS
            // ============================

            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: LEPPA",null,"Papel","Apple","Pepla","Palep","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: OGD",null,"God","Dgo","Dog","Odg","C"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: NUS",null,"Nus","Sun","Snu","Uns","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: TCA",null,"Tca","Act","Cat","Cta","C"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: USB",null,"Sub","Usb","Bus","Bsu","C"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: HSIF",null,"Hsif","Fish","Ifsh","Sfih","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: KOOB",null,"Koob","Obok","Book","Kobo","C"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: EETR",null,"Eetr","Rtee","Tere","Tree","D"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: LALB",null,"Lalb","Ball","Abll","Lbal","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: KLIM",null,"Klim","Ilmk","Lmki","Milk","D"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: ONOM",null,"Onom","Moon","Mono","Nomo","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: ARTS",null,"Arts","Tsar","Star","Rats","C"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: FELA",null,"Fela","Leaf","Aelf","Lefa","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: NIAR",null,"Niar","Iran","Rain","Anir","C"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: PHIS",null,"Phis","Hips","Ishp","Ship","D"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: KACE",null,"Kace","Cake","Eack","Ckea","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: CDUK",null,"Cduk","Duck","Ukcd","Dcuk","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: NOLI",null,"Noli","Olin","Lion","Ilon","C"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: RFOG",null,"Rfog","Frog","Gorf","Ofgr","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: NADH",null,"Nadh","Dahn","Hand","Hnad","C"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: PAML",null,"Paml","Mlpa","Lamp","Almp","C"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: NIRG",null,"Nirg","Ring","Grin","Irng","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: DRIB",null,"Drib","Rbdi","Bird","Ibdr","C"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: TBOA",null,"Tboa","Boat","Oabt","Bota","B"));
            questions.add(new Question(NeuroType.ADHD, basic, level1,"Unscramble the word: OORD",null,"Oord","Door","Rood","Odor","B"));

            // ============================
            // 25 IMAGE QUESTIONS
            // ============================

            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/apple.png","Carrot","Apple","Banana","Mango","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/dog.png","Dog","Cat","Car","Fish","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/car.png","Bus","Car","Train","Boat","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/sun.png","Moon","Star","Sun","Cloud","C"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/fish.png","Fish","Lion","Whale","Duck","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/banana.png","Banana","Mango","Chair","Apple","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/elephant.png","Elephant","Tiger","Table","Horse","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/chair.png","Chair","Sofa","Dog","Desk","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/clock.png","Clock","Watch","Apple","Ring","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/book.png","Pen","Book","Pencil","Ruler","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/cricketbat.png","Ball","Bat","Laptop","Racket","B"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/flower.png","Flower","Leaf","Bus","Tree","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/bus.png","Bus","Car","Banana","Train","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/house.png","House","School","Tiger","Temple","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/pen.png","Pen","Bottle","Marker","Pencil","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/mango.png","Mango","Orange","Train","Banana","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/cat.png","Cat","Dog","Table","Lion","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/leaf.png","Leaf","Root","Fish","Flower","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/train.png","Train","Plane","Apple","Bus","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/shoes.png","Shoes","Slippers","Carrot","Sandals","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/cow.png","Cow","Goat","Laptop","Buffalo","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/tiger.png","Tiger","Lion","Chair","Leopard","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/lion.png","Lion","Bus","Leopard","Tiger","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/monkey.png","Monkey","Gorilla","Clock","Chimpanzee","A"));
            questions.add(new Question(NeuroType.ADHD,basic,level1,"What is shown in the image?","/images/rabbit.png","Rabbit","Car","Hamster","Squirrel","A"));

            questionRepository.saveAll(questions);

            System.out.println("✅ ADHD Basic Level 1 — 50 questions inserted successfully!");
        };
    }
}