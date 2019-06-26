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
public class Courseware implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    public Courseware(Integer courseId, String name, String coursewarePath) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.coursewarePath = coursewarePath;
	}

    	
    
	public Courseware() {
		super();
	}



	@TableId
    private Integer courseId;

    private String name;

    private String coursewarePath;


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

    public String getCoursewarePath() {
        return coursewarePath;
    }

    public void setCoursewarePath(String coursewarePath) {
        this.coursewarePath = coursewarePath;
    }

    @Override
    public String toString() {
        return "Courseware{" +
        "courseId=" + courseId +
        ", name=" + name +
        ", coursewarePath=" + coursewarePath +
        "}";
    }
}
