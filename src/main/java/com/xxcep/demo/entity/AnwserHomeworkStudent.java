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
public class AnwserHomeworkStudent implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer questionId;

    private Integer scoreHomeworkStudentRelationId;

    private String anwserStudent;


    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getScoreHomeworkStudentRelationId() {
        return scoreHomeworkStudentRelationId;
    }

    public void setScoreHomeworkStudentRelationId(Integer scoreHomeworkStudentRelationId) {
        this.scoreHomeworkStudentRelationId = scoreHomeworkStudentRelationId;
    }

    public String getAnwserStudent() {
        return anwserStudent;
    }

    public void setAnwserStudent(String anwserStudent) {
        this.anwserStudent = anwserStudent;
    }

    @Override
    public String toString() {
        return "AnwserHomeworkStudent{" +
        "questionId=" + questionId +
        ", scoreHomeworkStudentRelationId=" + scoreHomeworkStudentRelationId +
        ", anwserStudent=" + anwserStudent +
        "}";
    }
}
