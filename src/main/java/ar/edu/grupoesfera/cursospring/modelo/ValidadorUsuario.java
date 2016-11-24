package ar.edu.grupoesfera.cursospring.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ValidadorUsuario implements Validator{
	 private Pattern pattern;
	 private Matcher matcher;
	 
	 private static final 
	 String NOMBREYAPELLIDO_PATTERN = "[A-Za-z ñáéíóú]{2,60}";
	 String DNI_PATTERN = "([0-9*]){8}";
	 String FECHANACIMIENTO_PATTERN = "(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))";
	 String DOMICILIO_PATTERN = "[a-zA-Z0-9 ñáéíóú]{2,60}";
	 String TELEFONO_PATTERN = "[0-9]{8,10}";
	 String EMAIL_PATTERN = "[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}";	
	 String CLAVE_PATTERN = "[A-Za-z0-9]{4,8}";

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		 Usuario usuario = (Usuario) target;

		  ValidationUtils.rejectIfEmpty(errors, "nombreYapellido", "required.nombreYapellido", "Completa Nombre y Apellido");
		  if (usuario.getNombreYapellido() != null) {
		   pattern = Pattern.compile(NOMBREYAPELLIDO_PATTERN);
		   matcher = pattern.matcher(usuario.getNombreYapellido().toString());
		   if (!matcher.matches()) {
		    errors.rejectValue("nombreYapellido", "nombreYapellido.incorrect", "Ej: Nombre Apellido");
		   }
		  }
		  
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "required.dni", "Completa DNI");
		  if (usuario.getDni() != null) {
		   pattern = Pattern.compile(DNI_PATTERN);
		   matcher = pattern.matcher(usuario.getDni().toString());		   
		   if (!matcher.matches()) {
		    errors.rejectValue("dni", "dni.incorrect", "Debe ingresar 8 dígitos sin puntos");
		   }
		  }

		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fechaNacimiento", "required.fechaNacimiento", "Completa Fecha de Nacimiento");
		  if (usuario.getFechaNacimiento() != null) {
		   pattern = Pattern.compile(FECHANACIMIENTO_PATTERN);
		   matcher = pattern.matcher(usuario.getFechaNacimiento().toString());
		   if (!matcher.matches()) {
		    errors.rejectValue("fechaNacimiento", "fechaNacimiento.incorrect", "Ej: AAAA-MM-DD");
		   }
		  }
		  
		  ValidationUtils.rejectIfEmpty(errors, "domicilio", "required.domicilio", "Completa Domicilio");
		  if (usuario.getDomicilio() != null) {
		   pattern = Pattern.compile(DOMICILIO_PATTERN);
		   matcher = pattern.matcher(usuario.getDomicilio().toString());
		   if (!matcher.matches()) {
		    errors.rejectValue("domicilio", "domicilio.incorrect", "Ej: Calle 13");
		   }
		  }
		
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "required.telefono", "Completa Teléfono");
		  if (usuario.getTelefono() != null) {
		   pattern = Pattern.compile(TELEFONO_PATTERN);
		   matcher = pattern.matcher(usuario.getTelefono().toString());
		   if (!matcher.matches()) {
		    errors.rejectValue("telefono", "telefono.incorrect", "Debe ingresar entre 8 y 10 dígitos sin guiones");
		   }
		  }
		  
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eMail", "required.eMail", "Completa E-mail");
		  if (usuario.geteMail() != null) {
		   pattern = Pattern.compile(EMAIL_PATTERN);
		   matcher = pattern.matcher(usuario.geteMail().toString());
		   if (!matcher.matches()) {
		    errors.rejectValue("eMail", "eMail", "Ej: nombre@mail.com");
		   }
		  }
	  
		  
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clave", "required.clave", "Completa Contraseña");
		  if (usuario.getClave() != null) {
			   pattern = Pattern.compile(CLAVE_PATTERN);
			   matcher = pattern.matcher(usuario.getClave().toString());
			   if (!matcher.matches()) {
			    errors.rejectValue("clave", "clave", "Debe contener entre 4 y 8 caracteres alfanuméricos");
			   }
		  }	
		  
		  if (!usuario.getClave().equals(usuario.getClave2())) {
		   errors.rejectValue("clave2", "clave.mismatch", "Las Contraseñas no coinciden");
		  }
		  
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tipo",
				    "required.tipo", "Completa Tipo");
	}
}
