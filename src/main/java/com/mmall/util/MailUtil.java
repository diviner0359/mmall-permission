package com.mmall.util;

import com.mmall.beans.Mail;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

@Slf4j
public class MailUtil {

    public static boolean send(Mail mail) {

        // TODO
        //仅仅是使用163邮箱发送到qq邮箱的一个测试
        String from = "diviner0359@163.com";//发送人的邮箱
        //int port = 465;
        String host = "smtp.163.com"; //这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
        String pass = "asdfg12345";  //***是你开启POP3服务时的授权码，不是登录密码
        String nickname = "Diviner0359";

        HtmlEmail email = new HtmlEmail();
        try {
            email.setHostName(host);
            email.setCharset("UTF-8");
            for (String str : mail.getReceivers()) {
                email.addTo(str);
            }
            email.setFrom(from, nickname);
            //用163邮箱作为发件箱时，不用设置端口，一设置就失败!
            //email.setSmtpPort(port);
            email.setAuthentication(from, pass);
            email.setSubject(mail.getSubject());
            email.setMsg(mail.getMessage());
            email.send();
            log.info("{} 发送邮件到 {}", from, StringUtils.join(mail.getReceivers(), ","));
            return true;
        } catch (EmailException e) {
            log.error(from + "发送邮件到" + StringUtils.join(mail.getReceivers(), ",") + "失败", e);
            return false;
        }
    }

}

