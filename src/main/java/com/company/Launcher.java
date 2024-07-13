package com.company;

import com.company.controller.rest.QuestionRestController;
//import com.company.controller.rest.UserRestController;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Launcher implements ApplicationRunner {
//    private final UserRestController userRestController;
    private final QuestionRestController questionRestController;

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        String filePath = "questions.dat";
//        List<QuestionRequest> hundredQuestionRequests = SaveDataUtil.getHundredQuestionRequests();
//
//        FileUtil.writeQuestionsToFile(hundredQuestionRequests, filePath);
//        List<QuestionRequest> readQuestions = FileUtil.readQuestionsFromFile(filePath);
//
//        readQuestions.forEach(System.out::println);
    }




}
