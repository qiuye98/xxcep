package com.xxcep.demo.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author G&H
 * @since 2019-06-13
 */
public class UserDialogueRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer dialogueId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDialogueId() {
        return dialogueId;
    }

    public void setDialogueId(Integer dialogueId) {
        this.dialogueId = dialogueId;
    }

    @Override
    public String toString() {
        return "UserDialogueRelation{" +
        "userId=" + userId +
        ", dialogueId=" + dialogueId +
        "}";
    }
}
