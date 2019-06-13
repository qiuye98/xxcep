package com.xxcep.demo.entity;

import java.io.Serializable;
import java.sql.Blob;

/**
 * <p>
 * 
 * </p>
 *
 * @author G&H
 * @since 2019-06-13
 */
public class Courseware implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer courseId;

    private String name;

    private Blob file;


    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Courseware{" +
        "courseId=" + courseId +
        ", name=" + name +
        ", file=" + file +
        "}";
    }
}
