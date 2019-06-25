package com.xxcep.demo.mapper;

import com.xxcep.demo.entity.Courseware;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author G&H
 * @since 2019-06-13
 */
public interface CoursewareMapper extends BaseMapper<Courseware> {
	
	
//	@Results(id = "coursewareMap", value = {
//			@Result(property = "courseId", column = "course_id", jdbcType = JdbcType.INTEGER),
//			@Result(property = "name", column = "name"),
//			@Result(property = "file", column = "file",jdbcType= JdbcType.BLOB)  })
//	
//	
//	@Select("select * from courseware")
//	public List<Courseware> findAll(); 
//	
	
//	@Select("select course_id,name from Courseware ")
//	@ResultMap(value = "coursewareMap")
//	public List<Courseware> listCoursewares();
	

}
