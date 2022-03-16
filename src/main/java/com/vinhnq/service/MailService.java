package com.vinhnq.service;

import com.vinhnq.beans.MailContentBeans;
import com.vinhnq.entity.User;
import org.springframework.mail.SimpleMailMessage;

public interface MailService {
    void alertForgotPassword(User users, MailContentBeans mailContentBeans);

    void alertLogin(User users, MailContentBeans mailContentBeans);

    void sentWelcome(User users, MailContentBeans mailContentBeans);

    void sendMail(SimpleMailMessage message);
}
