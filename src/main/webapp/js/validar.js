$(document).on('ready', function(){
	$('#boton').click(function(){
		var nombre = $('#nombre').val();
		var dni = $('#dni').val();
		var email = $('#email').val();
		var contraseña = $('#contraseña').val();
		var contraseña2 = $('#contraseña2').val();
		var domicilio = $('#domicilio').val();
		var numero = $('#numero').val();
		var email2 = $('#acceder-usuario').val();
		var contraseña3 = $('#acceder-contraseña').val();
		var expresion = /\w+@\w+\.+[a-z]/;
		var expresion2 = /[a-z]+\s+[0-9]/;
		var expresion3 = /^[0-9]+$/;
		var expresion4 = /[a-zA-ZáéíóúàèìòùÀÈÌÒÙÁÉÍÓÚñÑüÜ_\s]/;
		var expresion5 = /^[0-9a-z]+$/;

		if(!expresion4.test(nombre)){
			$('#alert1').html('Ingrese un nombre válido.').slideDown(500);
			$('#nombre').focus();
			return false;
		}
		
		else if(dni.length != 8){
			$('#alert2').html('El campo DNI debe tener 8 caracteres numéricos').slideDown(500);
			$('#dni').focus();
			return false;
		}
		
		else if(!expresion3.test(dni)){
			$('#alert2').html('El campo DNI debe tener 8 caracteres numéricos').slideDown(500);
			$('#dni').focus();
			return false;
		}

		else if(!expresion2.test(domicilio)){
			$('#alert6').html('Ingrese un domicilio válido').slideDown(500);
			$('#domicilio').focus();
			return false;
		}

		else if (!expresion3.test(numero) || numero.length < 10) {
			$('#alert7').html('El número ingresado no es válido.').slideDown(500);
			$('#numero').focus();
			return false;
		}
		
		else if (!expresion.test(email)){
			$('#alert3').html('El email ingresado no es correcto').slideDown(500);
			$('#email').focus();
			return false;
		}
		
		else if (contraseña.length < 6 || contraseña.length >11){
			$('#alert4').html('La contraseña debe tener entre 5 y 10 caracteres, y poseer letras y números').slideDown(500);
			$('#contraseña').focus();
			return false;
		}
		
		else if (!expresion5.test(contraseña)){
			$('#alert4').html('La contraseña debe tener entre 5 y 10 caracteres y poseer numeros y letras').slideDown(500);
			$('#contraseña').focus();
			return false;
		}
		
		else if (contraseña2 != contraseña){
		$('#alert5').html('Las contraseñas no coinciden').slideDown(500);
		$('#contraseña2').focus();
		return false;
		}

		else if (contraseña3 != contraseña){
			$('#alert8').html('El usuario y/o contraseña no coinciden.').slideDown(500);
			$('#acceder-contraseña').focus();
			return false;
		}
		

		else if (email2 != email){
			$('#alert8').html('El usuario y/o contraseña no coinciden.').slideDown(500);
			$('#acceder-usuario').focus();
			return false;
		}
	});
});
