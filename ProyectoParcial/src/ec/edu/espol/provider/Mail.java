/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.provider;

import java.util.Properties;
/*import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/
/**
 *
 * @author Mile
 */

/*FUENTEs:
    1. https://www.campusmvp.es/recursos/post/como-enviar-correo-electronico-con-java-a-traves-de-gmail.aspx
    2. https://www.youtube.com/watch?v=7khcvgM9rcM&t=285s
*/

public class Mail {
     public static void enviarMail(String destinatario, String asunto, String cuerpo){             
        String remitente = "stvnmr9@gmail.com";
        String clave = "0953062221";
        
        Properties props = System.getProperties();
        
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);   
        
        /*Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        
        try {
        message.setFrom(new InternetAddress(remitente));
        InternetAddress address= new InternetAddress(destinatario);
        message.addRecipient(Message.RecipientType.TO, address);   //Se podrían añadir varios de la misma manera
        message.setSubject(asunto);
        message.setText(cuerpo);
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", remitente, clave);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        }
        catch (MessagingException me){
            me.printStackTrace(); */
        }
        
     }

