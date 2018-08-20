package com.mall.test;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * Created by Diviner on 2018/8/19.
 * 仅仅是使用163邮箱发送到qq邮箱的一个测试
 */
public class T2 {
    public static void main(String[] args){
        HtmlEmail email = new HtmlEmail();
        try {
            // 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
            email.setHostName("smtp.163.com");
            // 字符编码集的设置
            email.setCharset("utf-8");
            // 收件人的邮箱
            email.addTo("3106601766@qq.com");
            // 发送人的邮箱2
            email.setFrom("diviner0359@163.com", "潘杰");
            // 如果需要认证信息的话，设置认证：用户名-密码     ***是你开启POP3服务时的授权码，不是登录密码
            email.setAuthentication("diviner0359@163.com", "asdfg12345");
            // 要发送的邮件主题
            email.setSubject("测试发送邮件");
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
            email.setMsg("测试发送邮件11111");
            // 发送
            email.send();
            System.out.println("发送成功");
        } catch (EmailException e) {
            e.printStackTrace();
            System.out.println("发送失败");
        }

    }
}
