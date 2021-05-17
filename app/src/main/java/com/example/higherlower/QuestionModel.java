package com.example.higherlower;

public class QuestionModel {
    private String question;
    private int correctAnswer;
    private String info;

    public QuestionModel(String question, int correctAnswer, String info) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.info = info;
    }

    public String getQuestion() {
        return question;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public String getInfo(){
        return info;
    }
}
