package com.fc.vo;

import lombok.Data;

@Data
public class MailVO {
    // 发件人
    private String from;
    // 收件人
    private String[] to;
    // 抄送
    private String[] cc;
    // 密抄
    private String[] bcc;
    // 主题
    private String subject;
    // 内容
    private String content;
}
