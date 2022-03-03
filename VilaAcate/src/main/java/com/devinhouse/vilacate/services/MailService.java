package com.devinhouse.vilacate.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    private MailSender MailSender;

    public MailService(MailSender MailSender) {
        this.MailSender = MailSender;
    }

    public void sendEmail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("phelipe44@gmail.com");
        mailMessage.setSubject("Relatorio!");
        mailMessage.setFrom("howjack44@gmail.com");
        mailMessage.setText("Tentaram mandar um relatorio financeiro para você");
        logger.info("Email Enviado!");
        MailSender.send(mailMessage);
    }
}
