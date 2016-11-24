package ar.edu.grupoesfera.cursospring.servicios;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface ContactoServicio {
	
	public void enviarMailSimple(String host, String port,
            final String usuario, final String password, String toAddress,
            String asunto, String texto) throws AddressException,
            MessagingException;

}
