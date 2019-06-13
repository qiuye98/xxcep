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
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer messageId;

    private LocalDateTime sendDate;

    private String content;

    private Integer dialogueId;


    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public LocalDateTime getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDateTime sendDate) {
        this.sendDate = sendDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getDialogueId() {
        return dialogueId;
    }

    public void setDialogueId(Integer dialogueId) {
        this.dialogueId = dialogueId;
    }

    @Override
    public String toString() {
        return "Message{" +
        "messageId=" + messageId +
        ", sendDate=" + sendDate +
        ", content=" + content +
        ", dialogueId=" + dialogueId +
        "}";
    }
}
