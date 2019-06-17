package com.xxcep.demo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;

/**
 * <p>
 * 
 * </p>
 *
 * @author G&H
 * @since 2019-06-13
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private Integer studentId;

    private String name;

    private String sex;

    private Integer score;

    private String password;


    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
        "studentId=" + studentId +
        ", name=" + name +
        ", sex=" + sex +
        ", score=" + score +
        ", password=" + password +
        "}";
    }
}
