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
public class ScoreExamStudentRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer studentId;

    private Integer examId;

    private Integer scoreExamStudentRelationId;

    private Integer score;


    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getScoreExamStudentRelationId() {
        return scoreExamStudentRelationId;
    }

    public void setScoreExamStudentRelationId(Integer scoreExamStudentRelationId) {
        this.scoreExamStudentRelationId = scoreExamStudentRelationId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ScoreExamStudentRelation{" +
        "studentId=" + studentId +
        ", examId=" + examId +
        ", scoreExamStudentRelationId=" + scoreExamStudentRelationId +
        ", score=" + score +
        "}";
    }
}
