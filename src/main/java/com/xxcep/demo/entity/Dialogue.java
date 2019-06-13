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
public class Dialogue implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer dialogueId;

    private LocalDateTime startDate;


    public Integer getDialogueId() {
        return dialogueId;
    }

    public void setDialogueId(Integer dialogueId) {
        this.dialogueId = dialogueId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Dialogue{" +
        "dialogueId=" + dialogueId +
        ", startDate=" + startDate +
        "}";
    }
}
