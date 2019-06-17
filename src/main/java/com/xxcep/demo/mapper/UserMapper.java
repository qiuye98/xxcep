package com.xxcep.demo.mapper;

import com.xxcep.demo.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 *
 * @author G&H
 * @since 2019-06-13
 */
public interface UserMapper extends BaseMapper<User> {

	
	@Select("select * from User")
	public List<User> findAll(); 

//	@Select("select * from t_User where User_account=#{account} and User_password=md5(#{password})")
//	@ResultMap(value = "UserMap")
//	public User validUser(@Param("account") String account, @Param("password") String password);
//
//	@Select("select * from t_User where User_name like concat('%',#{name},'%')")
//	@ResultMap(value = "UserMap")
//	public List<User> findByName(@Param("name") String name);
}
