package com.fc.entity;

public class TbNoteWithBLOBs extends TbNote {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

}