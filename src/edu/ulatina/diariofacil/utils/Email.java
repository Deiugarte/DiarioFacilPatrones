/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author blaken
 */
public class Email {

    public static void pedirProvedor(String provedor) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("rrhhcahuita@gmail.com", "cahuita123");
            }
        });

        try {
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("DF@diarioFacil.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(provedor));
            message.setSubject("Necesitamos producto");
            message.setText("Hola ,"
                    + "\n\n Necesitamos que visite nuestra tienda para resuplir el inventario!");

            Transport.send(message);
            System.out.println("Correo enviado a: " + provedor);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
