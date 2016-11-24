package ar.edu.grupoesfera.cursospring.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ValidadorProducto implements Validator{
	 private Pattern pattern;
	 private Matcher matcher;
	 
	 private static final 
	 String ID_PATTERN = "[0-9]+{1,8}";
	 String NOMBREPRODUCTO_PATTERN = "[A-Za-z Ò·ÈÌÛ˙]{2,15}";
	 String CATEGORIA_PATTERN = "[A-Z —¡…Õ”⁄]{2,15}";
	 String COLOR_PATTERN = "[A-Z —¡…Õ”⁄]{2,15}";
	 String TALLE_PATTERN = "[0-9A-Z —¡…Õ”⁄]{1,15}";
	 String DESCRIPCION_PATTERN = "[A-Za-z Ò·ÈÌÛ˙]{2,71}";
	 String PRECIO_PATTERN = "^[0-9]*+(.[0-9]*+)?$";
	


	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		 Producto producto = (Producto) target;
		
		 ValidationUtils.rejectIfEmpty(errors, "imagenproducto", "required.imagenproducto", "Selecciona una imagen");		 
	        if (producto.getImagenproducto().getOriginalFilename() == null) {
	            errors.reject("error.fichero.null");
	        } else {
	            ValidationUtils.rejectIfEmpty(errors, "imagenproducto",
	                    "error.fichero.imagenproducto.null");
	            if (producto.getImagenproducto() != null) {
	                if (producto.getImagenproducto().isEmpty()) {
	                    errors.rejectValue("imagenproducto", "error.fichero.imagenproducto.null", "Selecciona una imagen");
	                }
	            }
	        }

		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required.id", "Completa CÛdigo de Producto");
		  if (producto.getId() != null) {
		   pattern = Pattern.compile(ID_PATTERN);
		   matcher = pattern.matcher(producto.getId().toString());
		   if (!matcher.matches()) {
		    errors.rejectValue("id", "id.incorrect", "Debe ingresar entre 1 a 8 dÌgitos positivos");
		   }
		  }
		  
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoria", "required.categoria", "Selecciona Categoria");
		  if (producto.getCategoria() != null) {
			   pattern = Pattern.compile(CATEGORIA_PATTERN);
			   matcher = pattern.matcher(producto.getCategoria().toString());
			   if (!matcher.matches()) {
			    errors.rejectValue("categoria", "categoria.incorrect", "Ej: CATEGORIA");
			   }
			  }
		  
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombreProducto", "required.nombreProducto", "Completa Nombre Producto");
		  if (producto.getNombreProducto() != null) {
		   pattern = Pattern.compile(NOMBREPRODUCTO_PATTERN);
		   matcher = pattern.matcher(producto.getNombreProducto().toString());
		   if (!matcher.matches()) {
		    errors.rejectValue("nombreProducto", "nombreProducto.incorrect", "Ej: Producto");
		   }
		  }
		  
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "required.descripcion", "Completa DescripciÛn");
		  if (producto.getDescripcion() != null) {
		   pattern = Pattern.compile(DESCRIPCION_PATTERN);
		   matcher = pattern.matcher(producto.getDescripcion().toString());
		   if (!matcher.matches()) {
		    errors.rejectValue("descripcion", "descripcion.incorrect", "Ej: DescripciÛn del producto");
		   }
		  }
		  
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "color", "required.color", "Selecciona Color");
		  if (producto.getColor() != null) {
			   pattern = Pattern.compile(COLOR_PATTERN);
			   matcher = pattern.matcher(producto.getColor().toString());
			   if (!matcher.matches()) {
			    errors.rejectValue("color", "color.incorrect", "Ej: COLOR");
			   }
			  }
		  
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "talle", "required.talle", "Selecciona Talle");
		  if (producto.getTalle() != null) {
			   pattern = Pattern.compile(TALLE_PATTERN);
			   matcher = pattern.matcher(producto.getTalle().toString());
			   if (!matcher.matches()) {
			    errors.rejectValue("talle", "talle.incorrect", "Ej: XL Û 42");
			   }
			  }

		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "precio", "required.precio", "Completa Precio");
		  if (producto.getPrecio() != null) {
		   pattern = Pattern.compile(PRECIO_PATTERN);
		   matcher = pattern.matcher(producto.getPrecio().toString());
		   if (!matcher.matches()) {
		    errors.rejectValue("precio", "precio.incorrect", "Ej: 10.00");
		   }
		  }
		  
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "novedad",
				    "required.novedad", "Completa Novedad");
	}
}
