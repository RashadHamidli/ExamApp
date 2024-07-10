package com.company.util;

import com.company.dto.request.QuestionRequest;

import java.io.*;
import java.util.List;

public class FileUtil {

    public static void writeQuestionsToFile(List<QuestionRequest> questions, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(questions);
            System.out.println(STR."Questions have been written to \{filePath}");
        } catch (IOException e) {
            System.err.println(STR."Error writing questions to file: \{e.getMessage()}");
        }
    }

    public static List<QuestionRequest> readQuestionsFromFile(String filePath) {
        List<QuestionRequest> questions = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            questions = (List<QuestionRequest>) ois.readObject();
            System.out.println(STR."Questions have been read from \{filePath}");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(STR."Error reading questions from file: \{e.getMessage()}");
        }
        return questions;
    }
}

