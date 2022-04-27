package com.fc.controller;

import com.fc.vo.MailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@RestController
@RequestMapping("mail")
public class MailController {
    @Autowired
    private JavaMailSender sender;

    @RequestMapping("send")
    public String send(MailVO vo, MultipartFile[] file) throws MessagingException {
        // 复杂类型消息对象
        MimeMessage message = sender.createMimeMessage();

        // 如果需要传递附件，必须在构造方法中传递一个true
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        try {
            helper.setFrom(vo.getFrom());
            helper.setTo(vo.getTo());
            helper.setCc(vo.getCc());
            helper.setBcc(vo.getBcc());
            helper.setSubject(vo.getSubject());
            helper.setText(vo.getContent());
            // 设置发送的日期时间
            helper.setSentDate(new Date());

            // 添加附件
            if (file.length > 0) {
                for (MultipartFile multipartFile : file) {
                    if (!multipartFile.isEmpty() && multipartFile.getOriginalFilename() != null) {
                        helper.addAttachment(multipartFile.getOriginalFilename(), multipartFile);
                    }
                }
            }


            // 发送
            sender.send(message);

            return "发送成功！";
        } catch (MessagingException e) {
            e.printStackTrace();

            return "发送失败！";
        }
    }
}
