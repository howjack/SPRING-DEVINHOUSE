package com.devinhouse.vilacate.Exceptions;

import com.devinhouse.vilacate.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageException extends Exception{

    @Autowired
    MailService mailService;

    public MessageException() {
        mailService.sendEmail();
    }
}
