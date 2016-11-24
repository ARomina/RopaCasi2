package ar.edu.grupoesfera.cursospring.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import ar.edu.grupoesfera.cursospring.modelo.ClaseEnvioMail;
import ar.edu.grupoesfera.cursospring.modelo.Mail;
import ar.edu.grupoesfera.cursospring.modelo.ValidadorMensajeMail;
import ar.edu.grupoesfera.cursospring.servicios.ContactoServicio;

@Controller
public class ControladorContacto {
	
	@Inject
	private ContactoServicio servicioContacto;

	@RequestMapping ("/contacto")
	public ModelAndView cargaFormContacto(@ModelAttribute("mensaje")Mail mensaje){
		ModelMap modelo = new ModelMap();
		return new ModelAndView ("contacto", modelo);
	}
	
	@RequestMapping (path = "/contactoMensajeExito", method = RequestMethod.POST)
	public ModelAndView enviaMensaje(@ModelAttribute("mensaje")Mail mensaje, BindingResult resultado){
		ModelMap modelo = new ModelMap();
		//ClaseEnvioMail servicioContacto = ClaseEnvioMail.getInstance();
		
		//Validacion de datos
		ValidadorMensajeMail validadorMensajeMail = new ValidadorMensajeMail();
		validadorMensajeMail.validate(mensaje, resultado);
		if(resultado.hasErrors()){
			return new ModelAndView("contacto", modelo);
		}
		
		//MAIL
		try{
		// SMTP Server
		String host = "smtp.gmail.com";
		String port = "587";
		String mailTo = "info.ropas.app@gmail.com";
		String password = "ropasapp1";
		String mailFrom = "info.ropas.app@gmail.com";
		String asunto = mensaje.getAsuntoMail();
		String texto = "Enviado por: " + mensaje.getNombreMail() + " \nDirección de correo electrónico: " + mensaje.getEmailMail() + " \nMensaje: " + mensaje.getTextoMail();
        servicioContacto.enviarMailSimple(host, port, mailFrom, password, mailTo, asunto, texto);
        modelo.put("nombre", mensaje.getNombreMail());
		   return new ModelAndView ("contactoMensajeExito", modelo);
		}catch(Exception e){
		    e.printStackTrace();
		    return new ModelAndView("error", modelo);
		}
	}

	//Getters y Setters
	public ContactoServicio getServicioContacto() {
		return servicioContacto;
	}

	public void setServicioContacto(ContactoServicio servicioContacto) {
		this.servicioContacto = servicioContacto;
	}	
}