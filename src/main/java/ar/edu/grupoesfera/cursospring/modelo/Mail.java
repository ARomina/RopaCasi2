package ar.edu.grupoesfera.cursospring.modelo;

public class Mail {

	private String nombreMail;
	private String emailMail;
	private String asuntoMail;
	private String textoMail;
	
	public Mail(){}
	
	//Getters y Setters
	public String getNombreMail() {
		return nombreMail;
	}

	public void setNombreMail(String nombreMail) {
		this.nombreMail = nombreMail;
	}

	public String getEmailMail() {
		return emailMail;
	}

	public void setEmailMail(String emailMail) {
		this.emailMail = emailMail;
	}

	public String getAsuntoMail() {
		return asuntoMail;
	}

	public void setAsuntoMail(String asuntoMail) {
		this.asuntoMail = asuntoMail;
	}

	public String getTextoMail() {
		return textoMail;
	}

	public void setTextoMail(String textoMail) {
		this.textoMail = textoMail;
	}
	
}
