package com.xxcep.demo.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author G&H
 * @since 2019-06-13
 */
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer questionId;

    private String anwserStandart;

    private String questionDescribe;


    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getAnwserStandart() {
        return anwserStandart;
    }

    public void setAnwserStandart(String anwserStandart) {
        this.anwserStandart = anwserStandart;
    }

    public String getQuestionDescribe() {
        return questionDescribe;
    }

    public void setQuestionDescribe(String questionDescribe) {
        this.questionDescribe = questionDescribe;
    }

    @Override
    public String toString() {
        return "Question{" +
        "questionId=" + questionId +
        ", anwserStandart=" + anwserStandart +
        ", questionDescribe=" + questionDescribe +
        "}";
    }
}
