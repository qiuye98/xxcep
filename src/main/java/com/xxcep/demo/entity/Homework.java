package com.xxcep.demo.entity;

import java.time.LocalDate;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author G&H
 * @since 2019-06-26
 */
public class Homework implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private Integer homeworkId;

    private LocalDate beginDate;

    private LocalDate endDate;

    private String content;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Homework{" +
        "title=" + title +
        ", homeworkId=" + homeworkId +
        ", beginDate=" + beginDate +
        ", endDate=" + endDate +
        ", content=" + content +
        "}";
    }
}
