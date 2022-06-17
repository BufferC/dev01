package com.fc.entity;


public class AlleviationWithBLOBs extends Alleviation{
    private String content;
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

}
