package com.chat.models;


public class Message {
    private long messageId;
    private long timeCreated;
    private String content;

    public Message(long messageId, String content) {
        this.messageId = messageId;
        this.content = content;
        this.timeCreated = System.currentTimeMillis();
    }

    public Message(String line) {
        String[] components = line.split(",");
        messageId = Long.parseLong(components[0]);
        timeCreated = Long.parseLong(components[1]);
        content = components[2];
    }

    // Setter & Getter used to access the declared private variables
    // messageId
    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    // timeCreated
    public long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }

    // content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void printMessage() {
        System.out.println(toString());
    }

    public boolean isMe(long messageId) {
        return this.messageId == messageId;
    }

    @Override
    public String toString() {
        return String.format("%d,%d,%s", messageId, timeCreated, content);
    }
}
