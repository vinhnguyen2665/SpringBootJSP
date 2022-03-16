package vn.com.nsmv.service;

import org.springframework.mail.SimpleMailMessage;

import vn.com.nsmv.beans.MailContentBeans;
import vn.com.nsmv.entity.User;

public interface MailService {
    void alertForgotPassword(User users, MailContentBeans mailContentBeans);

    void alertLogin(User users, MailContentBeans mailContentBeans);

    void sentWelcome(User users, MailContentBeans mailContentBeans);

    void sendMail(SimpleMailMessage message);
}
