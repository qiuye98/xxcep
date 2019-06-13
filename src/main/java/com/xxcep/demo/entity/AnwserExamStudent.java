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
public class AnwserExamStudent implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer questionId;

    private Integer scoreExamStudentRelationId;

    private String anwserStudent;


    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getScoreExamStudentRelationId() {
        return scoreExamStudentRelationId;
    }

    public void setScoreExamStudentRelationId(Integer scoreExamStudentRelationId) {
        this.scoreExamStudentRelationId = scoreExamStudentRelationId;
    }

    public String getAnwserStudent() {
        return anwserStudent;
    }

    public void setAnwserStudent(String anwserStudent) {
        this.anwserStudent = anwserStudent;
    }

    @Override
    public String toString() {
        return "AnwserExamStudent{" +
        "questionId=" + questionId +
        ", scoreExamStudentRelationId=" + scoreExamStudentRelationId +
        ", anwserStudent=" + anwserStudent +
        "}";
    }
}
