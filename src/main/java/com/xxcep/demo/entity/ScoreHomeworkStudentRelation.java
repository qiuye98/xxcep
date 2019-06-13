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
public class ScoreHomeworkStudentRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer studentId;

    private Integer homeworkId;

    private Integer scoreHomeworkStudentRelationId;

    private Integer score;


    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Integer getScoreHomeworkStudentRelationId() {
        return scoreHomeworkStudentRelationId;
    }

    public void setScoreHomeworkStudentRelationId(Integer scoreHomeworkStudentRelationId) {
        this.scoreHomeworkStudentRelationId = scoreHomeworkStudentRelationId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ScoreHomeworkStudentRelation{" +
        "studentId=" + studentId +
        ", homeworkId=" + homeworkId +
        ", scoreHomeworkStudentRelationId=" + scoreHomeworkStudentRelationId +
        ", score=" + score +
        "}";
    }
}
