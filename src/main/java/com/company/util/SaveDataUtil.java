package com.company.util;

import com.company.dto.request.AnswerRequest;
import com.company.dto.request.QuestionRequest;
import com.company.dto.request.UserRequest;
import com.company.entity.Choice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveDataUtil {

    public static List<QuestionRequest> getHundredQuestionRequests() {
        List<QuestionRequest> questions = new ArrayList<>();

        for (int i = 1; i <= 33; i++) {
            questions.add(getSingleQuestionRequest(i));
            questions.add(getDoubleQuestionRequest(i + 33));
            questions.add(getTripleQuestionRequest(i + 66));
        }
        return questions;
    }

    public static List<UserRequest> getTenUserRequest() {
        UserRequest user1 = new UserRequest("john_brown", "John", "Brown", "john_brown@test_mail.com");
        UserRequest user2 = new UserRequest("emma_smith", "Emma", "Smith", "emma_smith@test_mail.com");
        UserRequest user3 = new UserRequest("michael_jones", "Michael", "Jones", "michael_jones@test_mail.com");
        UserRequest user4 = new UserRequest("sophia_davis", "Sophia", "Davis", "sophia_davis@test_mail.com");
        UserRequest user5 = new UserRequest("liam_miller", "Liam", "Miller", "liam_miller@test_mail.com");
        UserRequest user6 = new UserRequest("olivia_wilson", "Olivia", "Wilson", "olivia_wilson@test_mail.com");
        UserRequest user7 = new UserRequest("william_martin", "William", "Martin", "william_martin@test_mail.com");
        UserRequest user8 = new UserRequest("ava_anderson", "Ava", "Anderson", "ava_anderson@test_mail.com");
        UserRequest user9 = new UserRequest("james_thompson", "James", "Thompson", "james_thompson@test_mail.com");
        UserRequest user10 = new UserRequest("isabella_garcia", "Isabella", "Garcia", "isabella_garcia@test_mail.com");

        return Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
    }

    private static QuestionRequest getSingleQuestionRequest(int questionNumber) {
        String question=null;
        List<AnswerRequest> answers = switch (questionNumber) {
            case 1 -> {
                question = "What is the size of int in Java?";
                yield Arrays.asList(
                        new AnswerRequest("4 bytes", true),
                        new AnswerRequest("2 bytes", false),
                        new AnswerRequest("8 bytes", false),
                        new AnswerRequest("Depends on the platform", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 2 -> {
                question = "Which of these is a valid keyword in Java?";
                yield Arrays.asList(
                        new AnswerRequest("interface", true),
                        new AnswerRequest("unsigned", false),
                        new AnswerRequest("struct", false),
                        new AnswerRequest("goto", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 3 -> {
                question = "Which of these are selection statements in Java?";
                yield Arrays.asList(
                        new AnswerRequest("if()", true),
                        new AnswerRequest("for()", false),
                        new AnswerRequest("continue", false),
                        new AnswerRequest("break", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 4 -> {
                question = "What is the default value of a boolean variable?";
                yield Arrays.asList(
                        new AnswerRequest("false", true),
                        new AnswerRequest("true", false),
                        new AnswerRequest("0", false),
                        new AnswerRequest("null", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 5 -> {
                question = "Which method must be implemented by all threads?";
                yield Arrays.asList(
                        new AnswerRequest("run()", true),
                        new AnswerRequest("start()", false),
                        new AnswerRequest("stop()", false),
                        new AnswerRequest("main()", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 6 -> {
                question = "Which keyword is used for accessing the features of a package?";
                yield Arrays.asList(
                        new AnswerRequest("import", true),
                        new AnswerRequest("package", false),
                        new AnswerRequest("extends", false),
                        new AnswerRequest("synchronized", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 7 -> {
                question = "Which of these is used to implement abstraction in Java?";
                yield Arrays.asList(
                        new AnswerRequest("Abstract class", true),
                        new AnswerRequest("Interface", true),
                        new AnswerRequest("Both a and b", false),
                        new AnswerRequest("None of the above", false),
                        new AnswerRequest("All of the above", false)
                );
            }
            case 8 -> {
                question = "Which of these is a type of polymorphism in Java?";
                yield Arrays.asList(
                        new AnswerRequest("Compile-time", true),
                        new AnswerRequest("Run-time", true),
                        new AnswerRequest("Both a and b", false),
                        new AnswerRequest("None of the above", false),
                        new AnswerRequest("All of the above", false)
                );
            }
            case 9 -> {
                question = "Which of these is not a valid data type in Java?";
                yield Arrays.asList(
                        new AnswerRequest("int", false),
                        new AnswerRequest("float", false),
                        new AnswerRequest("boolean", false),
                        new AnswerRequest("char", false),
                        new AnswerRequest("double", true)
                );
            }
            case 10 -> {
                question = "Which of these is not an access modifier?";
                yield Arrays.asList(
                        new AnswerRequest("private", false),
                        new AnswerRequest("protected", false),
                        new AnswerRequest("public", false),
                        new AnswerRequest("volatile", true),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 11 -> {
                question = "Which of these is used to handle exceptions in Java?";
                yield Arrays.asList(
                        new AnswerRequest("try", true),
                        new AnswerRequest("catch", true),
                        new AnswerRequest("finally", true),
                        new AnswerRequest("throw", true),
                        new AnswerRequest("throws", true)
                );
            }
            case 12 -> {
                question = "Which of these is not a valid loop construct in Java?";
                yield Arrays.asList(
                        new AnswerRequest("for", false),
                        new AnswerRequest("while", false),
                        new AnswerRequest("do-while", false),
                        new AnswerRequest("foreach", true),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 13 -> {
                question = "Which of these is not a valid keyword in Java?";
                yield Arrays.asList(
                        new AnswerRequest("static", false),
                        new AnswerRequest("volatile", false),
                        new AnswerRequest("const", true),
                        new AnswerRequest("abstract", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 14 -> {
                question = "Which of these is a valid statement to create an array in Java?";
                yield Arrays.asList(
                        new AnswerRequest("int[] arr = new int[5];", true),
                        new AnswerRequest("int arr[] = new int[5];", true),
                        new AnswerRequest("int[] arr = new int[5];", true),
                        new AnswerRequest("int arr[] = int[5];", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 15 -> {
                question = "Which of these is not a feature of Java?";
                yield Arrays.asList(
                        new AnswerRequest("Object-oriented", false),
                        new AnswerRequest("Use of pointers", true),
                        new AnswerRequest("Portable", false),
                        new AnswerRequest("Dynamic and Extensible", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 16 -> {
                question = "What is the extension of compiled Java classes?";
                yield Arrays.asList(
                        new AnswerRequest(".class", true),
                        new AnswerRequest(".java", false),
                        new AnswerRequest(".js", false),
                        new AnswerRequest(".css", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 17 -> {
                question = "Which of these is not a Java feature?";
                yield Arrays.asList(
                        new AnswerRequest("Object-oriented", false),
                        new AnswerRequest("Use of pointers", true),
                        new AnswerRequest("Portable", false),
                        new AnswerRequest("Dynamic and Extensible", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 18 -> {
                question = "Which of these is not a valid data type in Java?";
                yield Arrays.asList(
                        new AnswerRequest("int", false),
                        new AnswerRequest("float", false),
                        new AnswerRequest("boolean", false),
                        new AnswerRequest("char", false),
                        new AnswerRequest("double", true)
                );
            }
            case 19 -> {
                question = "Which of these is not an access modifier?";
                yield Arrays.asList(
                        new AnswerRequest("private", false),
                        new AnswerRequest("protected", false),
                        new AnswerRequest("public", false),
                        new AnswerRequest("volatile", true),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 20 -> {
                question = "Which of these is used to handle exceptions in Java?";
                yield Arrays.asList(
                        new AnswerRequest("try", true),
                        new AnswerRequest("catch", true),
                        new AnswerRequest("finally", true),
                        new AnswerRequest("throw", true),
                        new AnswerRequest("throws", true)
                );
            }
            case 21 -> {
                question = "Which of these is not a valid loop construct in Java?";
                yield Arrays.asList(
                        new AnswerRequest("for", false),
                        new AnswerRequest("while", false),
                        new AnswerRequest("do-while", false),
                        new AnswerRequest("foreach", true),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 22 -> {
                question = "Which of these is not a valid keyword in Java?";
                yield Arrays.asList(
                        new AnswerRequest("static", false),
                        new AnswerRequest("volatile", false),
                        new AnswerRequest("const", true),
                        new AnswerRequest("abstract", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 23 -> {
                question = "Which of these is a valid statement to create an array in Java?";
                yield Arrays.asList(
                        new AnswerRequest("int[] arr = new int[5];", true),
                        new AnswerRequest("int arr[] = new int[5];", true),
                        new AnswerRequest("int[] arr = new int[5];", true),
                        new AnswerRequest("int arr[] = int[5];", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 24 -> {
                question = "Which of these is not a feature of Java?";
                yield Arrays.asList(
                        new AnswerRequest("Object-oriented", false),
                        new AnswerRequest("Use of pointers", true),
                        new AnswerRequest("Portable", false),
                        new AnswerRequest("Dynamic and Extensible", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 25 -> {
                question = "What is the extension of compiled Java classes?";
                yield Arrays.asList(
                        new AnswerRequest(".class", true),
                        new AnswerRequest(".java", false),
                        new AnswerRequest(".js", false),
                        new AnswerRequest(".css", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 26 -> {
                question = "Which of these is not a Java feature?";
                yield Arrays.asList(
                        new AnswerRequest("Object-oriented", false),
                        new AnswerRequest("Use of pointers", true),
                        new AnswerRequest("Portable", false),
                        new AnswerRequest("Dynamic and Extensible", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 27 -> {
                question = "Which of these is not a valid data type in Java?";
                yield Arrays.asList(
                        new AnswerRequest("int", false),
                        new AnswerRequest("float", false),
                        new AnswerRequest("boolean", false),
                        new AnswerRequest("char", false),
                        new AnswerRequest("double", true)
                );
            }
            case 28 -> {
                question = "Which of these is not an access modifier?";
                yield Arrays.asList(
                        new AnswerRequest("private", false),
                        new AnswerRequest("protected", false),
                        new AnswerRequest("public", false),
                        new AnswerRequest("volatile", true),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 29 -> {
                question = "Which of these is used to handle exceptions in Java?";
                yield Arrays.asList(
                        new AnswerRequest("try", true),
                        new AnswerRequest("catch", true),
                        new AnswerRequest("finally", true),
                        new AnswerRequest("throw", true),
                        new AnswerRequest("throws", true)
                );
            }
            case 30 -> {
                question = "Which of these is not a valid loop construct in Java?";
                yield Arrays.asList(
                        new AnswerRequest("for", false),
                        new AnswerRequest("while", false),
                        new AnswerRequest("do-while", false),
                        new AnswerRequest("foreach", true),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 31 -> {
                question = "Which of these is not a valid keyword in Java?";
                yield Arrays.asList(
                        new AnswerRequest("static", false),
                        new AnswerRequest("volatile", false),
                        new AnswerRequest("const", true),
                        new AnswerRequest("abstract", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 32 -> {
                question = "Which of these is a valid statement to create an array in Java?";
                yield Arrays.asList(
                        new AnswerRequest("int[] arr = new int[5];", true),
                        new AnswerRequest("int arr[] = new int[5];", true),
                        new AnswerRequest("int[] arr = new int[5];", true),
                        new AnswerRequest("int arr[] = int[5];", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 33 -> {
                question = "Which of these is not a feature of Java?";
                yield Arrays.asList(
                        new AnswerRequest("Object-oriented", false),
                        new AnswerRequest("Use of pointers", true),
                        new AnswerRequest("Portable", false),
                        new AnswerRequest("Dynamic and Extensible", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            default -> null;
        };

        return new QuestionRequest(question, Choice.SINGLE.name(), answers);
    }

    private static QuestionRequest getDoubleQuestionRequest(int questionNumber) {
        String question=null;
        List<AnswerRequest> answers = switch (questionNumber) {
            case 34 -> {
                question = "Which of these are access specifiers in Java?";
                yield Arrays.asList(
                        new AnswerRequest("private", true),
                        new AnswerRequest("protected", true),
                        new AnswerRequest("transient", false),
                        new AnswerRequest("volatile", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 35 -> {
                question = "Which of these is not a Java feature?";
                yield Arrays.asList(
                        new AnswerRequest("Object-oriented", true),
                        new AnswerRequest("Use of pointers", true),
                        new AnswerRequest("Portable", false),
                        new AnswerRequest("Dynamic and Extensible", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 36 -> {
                question = "Which of these is a correct way to create an array in Java?";
                yield Arrays.asList(
                        new AnswerRequest("int[] arr = new int[5];", true),
                        new AnswerRequest("int arr[] = new int[5];", true),
                        new AnswerRequest("int[] arr = int[5] new;", false),
                        new AnswerRequest("int arr[] = new int(5);", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 37 -> {
                question = "Which of these are valid loop constructs in Java?";
                yield Arrays.asList(
                        new AnswerRequest("for()", true),
                        new AnswerRequest("while()", true),
                        new AnswerRequest("do-while()", false),
                        new AnswerRequest("foreach()", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 38 -> {
                question = "Which of these are not valid keywords in Java?";
                yield Arrays.asList(
                        new AnswerRequest("goto", true),
                        new AnswerRequest("const", true),
                        new AnswerRequest("abstract", false),
                        new AnswerRequest("volatile", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 39 -> {
                question = "Which of these are valid primitive data types in Java?";
                yield Arrays.asList(
                        new AnswerRequest("int", true),
                        new AnswerRequest("boolean", true),
                        new AnswerRequest("String", false),
                        new AnswerRequest("double", true),
                        new AnswerRequest("char", true)
                );
            }
            case 40 -> {
                question = "Which of these are valid Java methods to handle exceptions?";
                yield Arrays.asList(
                        new AnswerRequest("try", true),
                        new AnswerRequest("catch", true),
                        new AnswerRequest("finally", true),
                        new AnswerRequest("throw", true),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 41 -> {
                question = "Which of these are valid loop constructs in Java?";
                yield Arrays.asList(
                        new AnswerRequest("for()", true),
                        new AnswerRequest("while()", true),
                        new AnswerRequest("do-while()", true),
                        new AnswerRequest("foreach()", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 42 -> {
                question = "Which of these are valid identifiers in Java?";
                yield Arrays.asList(
                        new AnswerRequest("myVar", true),
                        new AnswerRequest("_myVar", true),
                        new AnswerRequest("$myVar", true),
                        new AnswerRequest("1myVar", false),
                        new AnswerRequest("my-Var", false)
                );
            }
            case 43 -> {
                question = "Which of these are valid array declarations in Java?";
                yield Arrays.asList(
                        new AnswerRequest("int[] arr = new int[5];", true),
                        new AnswerRequest("int arr[] = new int[5];", true),
                        new AnswerRequest("int[] arr = int[5] new;", false),
                        new AnswerRequest("int arr[] = new int(5);", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 44 -> {
                question = "Which of these are not valid modifiers in Java?";
                yield Arrays.asList(
                        new AnswerRequest("public", false),
                        new AnswerRequest("private", false),
                        new AnswerRequest("static", false),
                        new AnswerRequest("unsigned", true),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 45 -> {
                question = "Which of these are valid Java access specifiers?";
                yield Arrays.asList(
                        new AnswerRequest("public", true),
                        new AnswerRequest("protected", true),
                        new AnswerRequest("private", true),
                        new AnswerRequest("transient", false),
                        new AnswerRequest("volatile", false)
                );
            }
            case 46 -> {
                question = "Which of these are valid loop constructs in Java?";
                yield Arrays.asList(
                        new AnswerRequest("for()", true),
                        new AnswerRequest("while()", true),
                        new AnswerRequest("do-while()", true),
                        new AnswerRequest("foreach()", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 47 -> {
                question = "Which of these are valid data types in Java?";
                yield Arrays.asList(
                        new AnswerRequest("int", true),
                        new AnswerRequest("float", true),
                        new AnswerRequest("boolean", true),
                        new AnswerRequest("char", true),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 48 -> {
                question = "Which of these are valid ways to create an object in Java?";
                yield Arrays.asList(
                        new AnswerRequest("new MyClass();", true),
                        new AnswerRequest("MyClass obj = new MyClass();", true),
                        new AnswerRequest("MyClass obj = MyClass();", false),
                        new AnswerRequest("MyClass obj = new();", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 49 -> {
                question = "Which of these are valid ways to declare a method in Java?";
                yield Arrays.asList(
                        new AnswerRequest("public void myMethod();", true),
                        new AnswerRequest("void myMethod();", true),
                        new AnswerRequest("public void myMethod();", true),
                        new AnswerRequest("public myMethod();", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 50 -> {
                question = "Which of these are valid Java keywords?";
                yield Arrays.asList(
                        new AnswerRequest("abstract", true),
                        new AnswerRequest("boolean", true),
                        new AnswerRequest("byte", true),
                        new AnswerRequest("class", true),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 51 -> {
                question = "Which of these are not valid Java access specifiers?";
                yield Arrays.asList(
                        new AnswerRequest("public", false),
                        new AnswerRequest("protected", false),
                        new AnswerRequest("private", false),
                        new AnswerRequest("default", true),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 52 -> {
                question = "Which of these are valid ways to handle exceptions in Java?";
                yield Arrays.asList(
                        new AnswerRequest("try", true),
                        new AnswerRequest("catch", true),
                        new AnswerRequest("finally", true),
                        new AnswerRequest("throw", true),
                        new AnswerRequest("throws", true)
                );
            }
            case 53 -> {
                question = "Which of these are valid Java loop constructs?";
                yield Arrays.asList(
                        new AnswerRequest("for", true),
                        new AnswerRequest("while", true),
                        new AnswerRequest("do-while", true),
                        new AnswerRequest("foreach", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 54 -> {
                question = "Which of these are not valid Java data types?";
                yield Arrays.asList(
                        new AnswerRequest("int", false),
                        new AnswerRequest("float", false),
                        new AnswerRequest("boolean", false),
                        new AnswerRequest("char", false),
                        new AnswerRequest("unsigned", true)
                );
            }
            case 55 -> {
                question = "Which of these are valid array declarations in Java?";
                yield Arrays.asList(
                        new AnswerRequest("int[] arr = new int[5];", true),
                        new AnswerRequest("int arr[] = new int[5];", true),
                        new AnswerRequest("int[] arr = int[5] new;", false),
                        new AnswerRequest("int arr[] = new int(5);", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 56 -> {
                question = "Which of these are valid Java keywords?";
                yield Arrays.asList(
                        new AnswerRequest("abstract", true),
                        new AnswerRequest("boolean", true),
                        new AnswerRequest("byte", true),
                        new AnswerRequest("class", true),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 57 -> {
                question = "Which of these are valid Java access specifiers?";
                yield Arrays.asList(
                        new AnswerRequest("public", true),
                        new AnswerRequest("protected", true),
                        new AnswerRequest("private", true),
                        new AnswerRequest("default", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 58 -> {
                question = "Which of these are valid Java loop constructs?";
                yield Arrays.asList(
                        new AnswerRequest("for", true),
                        new AnswerRequest("while", true),
                        new AnswerRequest("do-while", true),
                        new AnswerRequest("foreach", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 59 -> {
                question = "Which of these are valid Java exception handling mechanisms?";
                yield Arrays.asList(
                        new AnswerRequest("try", true),
                        new AnswerRequest("catch", true),
                        new AnswerRequest("finally", true),
                        new AnswerRequest("throw", true),
                        new AnswerRequest("throws", true)
                );
            }
            case 60 -> {
                question = "Which of these are valid Java variable names?";
                yield Arrays.asList(
                        new AnswerRequest("myVar", true),
                        new AnswerRequest("_myVar", true),
                        new AnswerRequest("$myVar", true),
                        new AnswerRequest("1myVar", false),
                        new AnswerRequest("my-Var", false)
                );
            }
            case 61 -> {
                question = "Which of these are valid Java method declarations?";
                yield Arrays.asList(
                        new AnswerRequest("public void myMethod();", true),
                        new AnswerRequest("void myMethod();", true),
                        new AnswerRequest("public void myMethod();", true),
                        new AnswerRequest("public myMethod();", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 62 -> {
                question = "Which of these are valid Java class declarations?";
                yield Arrays.asList(
                        new AnswerRequest("public class MyClass {}", true),
                        new AnswerRequest("class MyClass {}", true),
                        new AnswerRequest("MyClass {}", false),
                        new AnswerRequest("public MyClass {}", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 63 -> {
                question = "Which of these are valid Java constructors?";
                yield Arrays.asList(
                        new AnswerRequest("public MyClass() {}", true),
                        new AnswerRequest("MyClass() {}", true),
                        new AnswerRequest("public void MyClass() {}", false),
                        new AnswerRequest("void MyClass() {}", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 64 -> {
                question = "Which of these are valid Java primitive data types?";
                yield Arrays.asList(
                        new AnswerRequest("int", true),
                        new AnswerRequest("float", true),
                        new AnswerRequest("boolean", true),
                        new AnswerRequest("char", true),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 65 -> {
                question = "Which of these are valid Java array declarations?";
                yield Arrays.asList(
                        new AnswerRequest("int[] arr = new int[5];", true),
                        new AnswerRequest("int arr[] = new int[5];", true),
                        new AnswerRequest("int[] arr = int[5] new;", false),
                        new AnswerRequest("int arr[] = new int(5);", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 66 -> {
                question = "Which of these are valid Java keywords?";
                yield Arrays.asList(
                        new AnswerRequest("abstract", true),
                        new AnswerRequest("boolean", true),
                        new AnswerRequest("byte", true),
                        new AnswerRequest("class", true),
                        new AnswerRequest("None of the above", false)
                );
            }
            default -> null;
        };

        return new QuestionRequest(question, Choice.DOUBLE.name(), answers);
    }

    private static QuestionRequest getTripleQuestionRequest(int questionNumber) {
        String question=null;
        List<AnswerRequest> answers = switch (questionNumber) {
            case 67 -> {
                question = "Which of these are valid variable names in Java?";
                yield Arrays.asList(
                        new AnswerRequest("myVar", true),
                        new AnswerRequest("_myVar", true),
                        new AnswerRequest("$myVar", true),
                        new AnswerRequest("1myVar", false),
                        new AnswerRequest("my-Var", false)
                );
            }
            case 68 -> {
                question = "Which of these are valid modifiers in Java?";
                yield Arrays.asList(
                        new AnswerRequest("public", true),
                        new AnswerRequest("private", true),
                        new AnswerRequest("static", true),
                        new AnswerRequest("unsigned", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 69 -> {
                question = "Which of these are valid Java access specifiers?";
                yield Arrays.asList(
                        new AnswerRequest("public", true),
                        new AnswerRequest("protected", true),
                        new AnswerRequest("private", true),
                        new AnswerRequest("transient", false),
                        new AnswerRequest("volatile", false)
                );
            }
            case 70 -> {
                question = "Which of these are valid loop constructs in Java?";
                yield Arrays.asList(
                        new AnswerRequest("for()", true),
                        new AnswerRequest("while()", true),
                        new AnswerRequest("do-while()", true),
                        new AnswerRequest("foreach()", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 71 -> {
                question = "Which of these are valid Java collection classes?";
                yield Arrays.asList(
                        new AnswerRequest("ArrayList", true),
                        new AnswerRequest("HashMap", true),
                        new AnswerRequest("TreeSet", true),
                        new AnswerRequest("Graph", false),
                        new AnswerRequest("Node", false)
                );
            }
            case 72 -> {
                question = "Which of these are Java interface types?";
                yield Arrays.asList(
                        new AnswerRequest("Runnable", true),
                        new AnswerRequest("Serializable", true),
                        new AnswerRequest("Comparable", true),
                        new AnswerRequest("String", false),
                        new AnswerRequest("ArrayList", false)
                );
            }
            case 73 -> {
                question = "Which of these are valid Java thread methods?";
                yield Arrays.asList(
                        new AnswerRequest("start()", true),
                        new AnswerRequest("run()", true),
                        new AnswerRequest("sleep()", true),
                        new AnswerRequest("begin()", false),
                        new AnswerRequest("pause()", false)
                );
            }
            case 74 -> {
                question = "Which of these are valid Java annotations?";
                yield Arrays.asList(
                        new AnswerRequest("@Override", true),
                        new AnswerRequest("@Deprecated", true),
                        new AnswerRequest("@SuppressWarnings", true),
                        new AnswerRequest("@Implemented", false),
                        new AnswerRequest("@Tested", false)
                );
            }
            case 75 -> {
                question = "Which of these are valid Java loop constructs?";
                yield Arrays.asList(
                        new AnswerRequest("for", true),
                        new AnswerRequest("while", true),
                        new AnswerRequest("do-while", true),
                        new AnswerRequest("repeat", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 76 -> {
                question = "Which of these are valid Java exception handling keywords?";
                yield Arrays.asList(
                        new AnswerRequest("try", true),
                        new AnswerRequest("catch", true),
                        new AnswerRequest("finally", true),
                        new AnswerRequest("handle", false),
                        new AnswerRequest("rescue", false)
                );
            }
            case 77 -> {
                question = "Which of these are valid Java I/O classes?";
                yield Arrays.asList(
                        new AnswerRequest("File", true),
                        new AnswerRequest("FileReader", true),
                        new AnswerRequest("BufferedReader", true),
                        new AnswerRequest("Directory", false),
                        new AnswerRequest("FileHandler", false)
                );
            }
            case 78 -> {
                question = "Which of these are valid Java access modifiers?";
                yield Arrays.asList(
                        new AnswerRequest("public", true),
                        new AnswerRequest("private", true),
                        new AnswerRequest("protected", true),
                        new AnswerRequest("open", false),
                        new AnswerRequest("closed", false)
                );
            }
            case 79 -> {
                question = "Which of these are valid Java method return types?";
                yield Arrays.asList(
                        new AnswerRequest("int", true),
                        new AnswerRequest("String", true),
                        new AnswerRequest("void", true),
                        new AnswerRequest("method", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 80 -> {
                question = "Which of these are valid Java inheritance types?";
                yield Arrays.asList(
                        new AnswerRequest("single", true),
                        new AnswerRequest("multilevel", true),
                        new AnswerRequest("hierarchical", true),
                        new AnswerRequest("parallel", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 81 -> {
                question = "Which of these are valid Java synchronization mechanisms?";
                yield Arrays.asList(
                        new AnswerRequest("synchronized keyword", true),
                        new AnswerRequest("Lock interface", true),
                        new AnswerRequest("Semaphore class", true),
                        new AnswerRequest("Monitor class", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 82 -> {
                question = "Which of these are valid Java multithreading classes?";
                yield Arrays.asList(
                        new AnswerRequest("Thread", true),
                        new AnswerRequest("Executor", true),
                        new AnswerRequest("FutureTask", true),
                        new AnswerRequest("RunnableTask", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 83 -> {
                question = "Which of these are valid Java serialization mechanisms?";
                yield Arrays.asList(
                        new AnswerRequest("Serializable interface", true),
                        new AnswerRequest("Externalizable interface", true),
                        new AnswerRequest("ObjectOutputStream", true),
                        new AnswerRequest("Serializer class", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 84 -> {
                question = "Which of these are valid Java garbage collection types?";
                yield Arrays.asList(
                        new AnswerRequest("Mark and Sweep", true),
                        new AnswerRequest("Generational", true),
                        new AnswerRequest("Reference Counting", true),
                        new AnswerRequest("Object Cleanup", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 85 -> {
                question = "Which of these are valid Java method parameters?";
                yield Arrays.asList(
                        new AnswerRequest("int", true),
                        new AnswerRequest("String", true),
                        new AnswerRequest("double", true),
                        new AnswerRequest("method", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 86 -> {
                question = "Which of these are valid Java final keywords usage?";
                yield Arrays.asList(
                        new AnswerRequest("final class", true),
                        new AnswerRequest("final method", true),
                        new AnswerRequest("final variable", true),
                        new AnswerRequest("final package", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 87 -> {
                question = "Which of these are valid Java method overloading rules?";
                yield Arrays.asList(
                        new AnswerRequest("Different parameter types", true),
                        new AnswerRequest("Different number of parameters", true),
                        new AnswerRequest("Different order of parameters", true),
                        new AnswerRequest("Different method names", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 88 -> {
                question = "Which of these are valid Java method overriding rules?";
                yield Arrays.asList(
                        new AnswerRequest("Same method name", true),
                        new AnswerRequest("Same parameter types", true),
                        new AnswerRequest("Same return type", true),
                        new AnswerRequest("Same method visibility", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 89 -> {
                question = "Which of these are valid Java packages?";
                yield Arrays.asList(
                        new AnswerRequest("java.lang", true),
                        new AnswerRequest("java.util", true),
                        new AnswerRequest("java.io", true),
                        new AnswerRequest("java.net", true),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 90 -> {
                question = "Which of these are valid Java generics usage?";
                yield Arrays.asList(
                        new AnswerRequest("List<T>", true),
                        new AnswerRequest("Map<K, V>", true),
                        new AnswerRequest("Class<T>", true),
                        new AnswerRequest("Generic<T>", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 91 -> {
                question = "Which of these are valid Java static keyword usage?";
                yield Arrays.asList(
                        new AnswerRequest("static variable", true),
                        new AnswerRequest("static method", true),
                        new AnswerRequest("static block", true),
                        new AnswerRequest("static class", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 92 -> {
                question = "Which of these are valid Java exception types?";
                yield Arrays.asList(
                        new AnswerRequest("RuntimeException", true),
                        new AnswerRequest("IOException", true),
                        new AnswerRequest("SQLException", true),
                        new AnswerRequest("Error", true),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 93 -> {
                question = "Which of these are valid Java assertions?";
                yield Arrays.asList(
                        new AnswerRequest("assert condition;", true),
                        new AnswerRequest("assert condition : message;", true),
                        new AnswerRequest("assertTrue(condition);", false),
                        new AnswerRequest("verify(condition);", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 94 -> {
                question = "Which of these are valid Java functional interfaces?";
                yield Arrays.asList(
                        new AnswerRequest("Runnable", true),
                        new AnswerRequest("Callable", true),
                        new AnswerRequest("Supplier", true),
                        new AnswerRequest("Stream", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 95 -> {
                question = "Which of these are valid Java String methods?";
                yield Arrays.asList(
                        new AnswerRequest("length()", true),
                        new AnswerRequest("charAt()", true),
                        new AnswerRequest("substring()", true),
                        new AnswerRequest("toLowerCase()", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 96 -> {
                question = "Which of these are valid Java thread states?";
                yield Arrays.asList(
                        new AnswerRequest("NEW", true),
                        new AnswerRequest("RUNNABLE", true),
                        new AnswerRequest("BLOCKED", true),
                        new AnswerRequest("PAUSED", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 97 -> {
                question = "Which of these are valid Java file handling classes?";
                yield Arrays.asList(
                        new AnswerRequest("File", true),
                        new AnswerRequest("FileWriter", true),
                        new AnswerRequest("FileReader", true),
                        new AnswerRequest("Directory", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 98 -> {
                question = "Which of these are valid Java design patterns?";
                yield Arrays.asList(
                        new AnswerRequest("Singleton", true),
                        new AnswerRequest("Observer", true),
                        new AnswerRequest("Connector", true),
                        new AnswerRequest("Manager", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 99 -> {
                question = "Which of these are valid Java data structures?";
                yield Arrays.asList(
                        new AnswerRequest("LinkedList", true),
                        new AnswerRequest("BinaryTree", true),
                        new AnswerRequest("HashTable", true),
                        new AnswerRequest("HeapList", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            case 100 -> {
                question = "Which of these are valid Java annotation elements?";
                yield Arrays.asList(
                        new AnswerRequest("value", true),
                        new AnswerRequest("name", true),
                        new AnswerRequest("description", true),
                        new AnswerRequest("content", false),
                        new AnswerRequest("None of the above", false)
                );
            }
            default -> throw new IllegalArgumentException("Invalid question number: " + questionNumber);
        };
        return new QuestionRequest(question, Choice.TRIPLE.name(), answers);
    }


}
