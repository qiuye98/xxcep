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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private Integer userId;

    private String account;

    private String password;

    private String name;

    private String sex;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
        "userId=" + userId +
        ", account=" + account +
        ", password=" + password +
        ", name=" + name +
        ", sex=" + sex +
        "}";
    }
}
