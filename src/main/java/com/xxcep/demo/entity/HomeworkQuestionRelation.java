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
public class HomeworkQuestionRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer homeworkId;

    private Integer questionId;


    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "HomeworkQuestionRelation{" +
        "homeworkId=" + homeworkId +
        ", questionId=" + questionId +
        "}";
    }
}
