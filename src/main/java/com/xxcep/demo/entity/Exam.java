package com.xxcep.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author G&H
 * @since 2019-06-13
 */
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer examId;

    private LocalDateTime beginDate;

    private LocalDateTime endDate;

    private String examName;


    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDateTime beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    @Override
    public String toString() {
        return "Exam{" +
        "examId=" + examId +
        ", beginDate=" + beginDate +
        ", endDate=" + endDate +
        ", examName=" + examName +
        "}";
    }
}
