package ar.edu.grupoesfera.cursospring.servicios;

import org.springframework.stereotype.Service;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service("servicioContacto")
public class ContactoServicioImpl implements ContactoServicio{

	//Envio de mail
	public void enviarMailSimple(String host, String port,
                                 final String usuario, final String password, 
                                 String toAddress, String asunto, String texto) 
                                 throws AddressException, MessagingException{
 
        // establece las propiedades SMTP
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.host", host);
        propiedades.put("mail.smtp.port", port);
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
 
        // crea una nueva sesion autenticada
        Authenticator auth = new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, password);
            }
        };
 
        // intancia la sesion, pasa las propiedades y la autenticacion
        Session session = Session.getInstance(propiedades, auth);
 
        // crea nuevo mensaje de mail
        Message mail = new MimeMessage(session);
 
        //caracteristicas del mail
        mail.setFrom(new InternetAddress(usuario));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        mail.setRecipients(Message.RecipientType.TO, toAddresses);
        mail.setSubject(asunto);
        mail.setText(texto);
 
        // envia el mail
        Transport.send(mail);
 
    }
	
}