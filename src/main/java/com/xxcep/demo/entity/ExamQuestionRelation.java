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
public class ExamQuestionRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer examId;

    private Integer questionId;


    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "ExamQuestionRelation{" +
        "examId=" + examId +
        ", questionId=" + questionId +
        "}";
    }
}
