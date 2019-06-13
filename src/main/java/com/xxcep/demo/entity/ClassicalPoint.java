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
public class ClassicalPoint implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer classicalPointId;

    private String name;

    private Blob file;


    public Integer getClassicalPointId() {
        return classicalPointId;
    }

    public void setClassicalPointId(Integer classicalPointId) {
        this.classicalPointId = classicalPointId;
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
        return "ClassicalPoint{" +
        "classicalPointId=" + classicalPointId +
        ", name=" + name +
        ", file=" + file +
        "}";
    }
}
