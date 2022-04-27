package com.fc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@SpringBootTest
public class MailTest {
    // java的邮件发送器
    @Autowired
    private JavaMailSender sender;

    @Test
    void testHtmlMail() {
        String content = "<img src='https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fweixin.sanbiaoge.com%2Fcunchu5%2F2021-02-07%2F4_16126366717967458.jpg&refer=http%3A%2F%2Fweixin.sanbiaoge.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1653634723&t=3453e2ae22329ffc6faa90a98f73a147' alt='图片'>" +
                "<font align='center' color='red'>" +
                "我叫张XX，因长得太帅，找不到对象..." +
                "</font>";

        // html类型邮件
        MimeMessage mimeMessage = sender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setFrom("2937753364@qq.com");

            helper.setTo(new String[] {
                    "2904937506@qq.com",
                    "813818443@qq.com",
                    "3335939034@qq.com",
                    "2998701715@qq.com",
                    "412790423@qq.com"
            });

            helper.setCc("1977331678@qq.com");

            helper.setBcc("635702657@qq.com");

            helper.setSubject("找对象");

            helper.setText(content, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        sender.send(mimeMessage);
    }

    @Test
    void testSimpleMail() {
        // 创建一个简单邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件的发送人
        message.setFrom("2937753364@qq.com");
        // 设置邮件的接收人
        message.setTo("2904937506@qq.com",
                "813818443@qq.com",
                "3335939034@qq.com",
                "2998701715@qq.com",
                "412790423@qq.com");

        // 设置邮件的主题
        message.setSubject("面试offer通知");

        // 设置邮件的内容
        message.setText("你好，我是秦始皇，其实我并没有死！我在西安有 100 亿吨黄金，我现在只需 100 元人民币来解冻我在西安的黄金！你微信、支付宝转给我都可以，账号就是我的手机号！转过来我直接带兵打过去，让你统领三军！");
        // 设置抄送人
        message.setCc("635702657@qq.com");
        // 秘密抄送
        message.setBcc("1977331678@qq.com");

        sender.send(message);
    }
}
