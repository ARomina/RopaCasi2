package ar.edu.grupoesfera.cursospring.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ValidadorMensajeMail implements Validator{

	 private Pattern pattern;
	 private Matcher matcher;
	 
	 private static final 
	 String NOMBRE_PATTERN = "[A-Za-z ραινσϊ]{2,60}";
	 String ASUNTO_PATTERN = "[a-zA-Z0-9 ραινσϊ]{2,60}";
	 String EMAIL_PATTERN = "[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}";	

	 @Override
		public boolean supports(Class<?> clazz) {
			return false;
		}

		@Override
		public void validate(Object target, Errors errors) {
			 Mail mail = (Mail) target;

			  ValidationUtils.rejectIfEmpty(errors, "nombreMail", "required.nombreMail", "Completa el nombre");
			  if (mail.getNombreMail() != null) {
			   pattern = Pattern.compile(NOMBRE_PATTERN);
			   matcher = pattern.matcher(mail.getNombreMail().toString());
			   if (!matcher.matches()) {
			    errors.rejectValue("nombreMail", "nombreMail.incorrect", "Ej: Nombre");
			   }
			  }
			  
			  ValidationUtils.rejectIfEmpty(errors, "asuntoMail", "required.asuntoMail", "Completa el asunto");
			  if (mail.getAsuntoMail() != null) {
			   pattern = Pattern.compile(ASUNTO_PATTERN);
			   matcher = pattern.matcher(mail.getAsuntoMail().toString());
			   if (!matcher.matches()) {
			    errors.rejectValue("asuntoMail", "asuntoMail.incorrect", "Ej: Quisiera mαs vestidos de talla 2");
			   }
			  }
			  
			  ValidationUtils.rejectIfEmpty(errors, "textoMail", "required.textoMail", "Completa el mensaje");
			  
			  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailMail", "required.emailMail", "Completa E-mail");
			  if (mail.getEmailMail() != null) {
			   pattern = Pattern.compile(EMAIL_PATTERN);
			   matcher = pattern.matcher(mail.getEmailMail().toString());
			   if (!matcher.matches()) {
			    errors.rejectValue("emailMail", "emailMail", "Ej: nombre@mail.com");
			   }
			  }
		}
}
