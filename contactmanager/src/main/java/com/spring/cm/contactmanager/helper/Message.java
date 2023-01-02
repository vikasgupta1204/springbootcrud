package com.spring.cm.contactmanager.helper;

public class Message {
    private String content;
    private String type;

    public Message() {
    }

    public Message(String content, String type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Message content(String content) {
        setContent(content);
        return this;
    }

    public Message type(String type) {
        setType(type);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " content='" + getContent() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }


}