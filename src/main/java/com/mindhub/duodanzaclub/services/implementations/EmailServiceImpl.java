package com.mindhub.duodanzaclub.services.implementations;

import com.mindhub.duodanzaclub.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String to, String subject, String content){
        SimpleMailMessage email = new SimpleMailMessage();


        email.setTo(to);
        email.setSubject(subject);
        email.setText(content);


        mailSender.send(email);
    }
}
