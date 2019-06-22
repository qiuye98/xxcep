package com.xxcep.demo.mapper;

import com.xxcep.demo.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 *
 * @author G&H
 * @since 2019-06-13
 */
public interface UserMapper extends BaseMapper<User> {

	@Results(id = "userMap", value = {
			@Result(property = "userId", column = "user_id", jdbcType = JdbcType.INTEGER),
			@Result(property = "account", column = "account"),
			@Result(property = "password", column = "password"),
			@Result(property = "name", column = "name"),
			@Result(property = "sex", column = "sex")	})
	
	
	@Select("select * from User")
	public List<User> findAll(); 

	@Select("select * from user where account=#{account} and password=#{password}")
	@ResultMap(value = "userMap")
	public User validUser(@Param("account") String account, @Param("password") String password);

//	@Select("select * from t_User where User_name like concat('%',#{name},'%')")
//	@ResultMap(value = "UserMap")
//	public List<User> findByName(@Param("name") String name);
}
