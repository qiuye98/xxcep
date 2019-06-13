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
public class Homework implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer homeworkId;

    private LocalDateTime beginDate;

    private LocalDateTime endDate;

    private String homewordName;


    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
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

    public String getHomewordName() {
        return homewordName;
    }

    public void setHomewordName(String homewordName) {
        this.homewordName = homewordName;
    }

    @Override
    public String toString() {
        return "Homework{" +
        "homeworkId=" + homeworkId +
        ", beginDate=" + beginDate +
        ", endDate=" + endDate +
        ", homewordName=" + homewordName +
        "}";
    }
}
