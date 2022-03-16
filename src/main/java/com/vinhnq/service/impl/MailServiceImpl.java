package com.vinhnq.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import com.vinhnq.beans.MailContentBeans;
import com.vinhnq.common.CommonConst;
import com.vinhnq.entity.User;
import com.vinhnq.service.MailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MailServiceImpl implements MailService {
    private static final Logger logger = LogManager.getLogger(MailServiceImpl.class);
    public final JavaMailSender emailSender;

    public MailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void alertForgotPassword(User users, MailContentBeans mailContentBeans) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            String mes = "Hey " +  users.getUserName() + ", \nYou account was request forgot password on: " + new Date();
            mes += "\n";
            mes += "\n";
            mes += "If you did not attempt to sign in to your account, your password may be compromised. Open Tityss Application to create a new, strong password for your Tityss account.";
            mes += "\n";
            mes += "\n";
            mes += "New password is: ";
            mes += users.getPassword();
            mes += "\n";
            mes += "\n";
            mes += "Thanks,\n" + "The Tityss Team\n";

            message.setTo(users.getEmail());
            message.setFrom(CommonConst.MAIL.USERNAME);
            message.setSubject("Security alert for your account");
            message.setText(mes);
            this.sendMail(message);
        } catch (Exception ex) {
            logger.error(ex.getMessage(),ex);
            throw new RuntimeException(ex.getMessage(),ex);
        }
    }

    @Override
    public void alertLogin(User users, MailContentBeans mailContentBeans) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            String username = (users.getFirstName() == null ? "" : users.getFirstName()) + " " + (users.getLastName() == null ? "" : users.getLastName());
            String mes = "Hey " + (username.equals(" ") ? users.getUserName() :  username)+ ", \nYou account was login on: " + new Date();
            mes += "\n";
            mes += "If you did not attempt to sign in to your account, your password may be compromised. Open Tityss Application to create a new, strong password for your Tityss account.";
            mes += "\n";
            mes += "Thanks,\n" + "The Tityss Team\n";
            message.setTo(users.getEmail());
            message.setFrom(CommonConst.MAIL.USERNAME);
            message.setSubject("Security alert for your account");
            message.setText(mes);
            this.sendMail(message);
        } catch (Exception ex) {
            logger.error(ex.getMessage(),ex);
        }
    }

    @Override
    public void sentWelcome(User users, MailContentBeans mailContentBeans) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            String username = (users.getFirstName() == null ? "" : users.getFirstName()) + " " + (users.getLastName() == null ? "" : users.getLastName());
            String mes = "Hey "  + (username.equals(" ") ? users.getUserName() :  username)+ ",";
            mes += "\n";
            mes += "\n";
            mes += "You have active account on CountPipe System.\n Thank you to chose my system.\n";;
            mes += "If have any question please reply this e-mail.\n\n";
            mes += "Thanks,\n" + "The Tityss Team\n";

            message.setTo(users.getEmail());
            message.setFrom(CommonConst.MAIL.USERNAME);
            message.setSubject("Security alert for your account");
            message.setText(mes);


            this.sendMail(message);
        } catch (Exception ex) {
            logger.error(ex.getMessage(),ex);
            throw new RuntimeException(ex.getMessage(),ex);
        }
    }

    @Override
    public void sendMail(SimpleMailMessage message) {
        try {
            if(message.getTo() != null){
                this.emailSender.send(message);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(),ex);
        }
    }
}
