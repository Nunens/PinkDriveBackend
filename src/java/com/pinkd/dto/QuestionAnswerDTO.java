/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pinkd.dto;

import com.pinkd.data.QuestionAnswer;

/**
 *
 * @author Sipho
 */
public class QuestionAnswerDTO {

    private int questionID;
    private String question, username, adminname;
    private String answer;
    private long date;
    private String status;
    private int userID;
    private int adminID;

    public QuestionAnswerDTO() {

    }

    public QuestionAnswerDTO(QuestionAnswer a) {
        questionID = a.getQuestionID();
        question = a.getQuestion();
        answer = a.getAnswer();
        date = a.getDate().getTime();
        status = a.getStatus();
        userID = a.getUser().getUserID();
        adminID = a.getAdmin().getAdminID();
        username = a.getUser().getName();
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }
    
    

}
