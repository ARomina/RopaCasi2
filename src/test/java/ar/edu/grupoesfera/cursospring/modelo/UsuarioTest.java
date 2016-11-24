package ar.edu.grupoesfera.cursospring.modelo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class UsuarioTest extends SpringTest{
	
	//Test creacion de usuario correcto
	@Test
	@Transactional
	@Rollback(true)
	
	public void TestPersona1(){
		
		Usuario usuarioTest = new Usuario();
		usuarioTest.setNombreYapellido("Rodrigo Rodriguez");
		usuarioTest.setFechaNacimiento("2010-11-11");
		usuarioTest.setDomicilio("Ferreris 345");
		usuarioTest.setDni(8345213);
		usuarioTest.setTelefono(22345643);
		usuarioTest.seteMail("rodriguez@gmail.com");
		usuarioTest.setClave("1234");
		usuarioTest.setClave2("1234");
		usuarioTest.setTipo("usuario");
		
	}
	
	//Test creacion de usuario incorrecto (Passwords no coinciden)
		@Test
		@Transactional
		@Rollback(true)
		
		public void TestPersona2(){
			
			Usuario  usuarioTest = new Usuario();
			usuarioTest.setNombreYapellido("Rodrigo Rodriguez");
			usuarioTest.setFechaNacimiento("2010-11-11");
			usuarioTest.setDomicilio("Ferreris 345");
			usuarioTest.setDni(8345213);
			usuarioTest.setTelefono(22345643);
			usuarioTest.seteMail("rodriguez@gmail.com");
			usuarioTest.setClave("1223");
			usuarioTest.setClave2("1243");
			usuarioTest.setTipo("usuario");
		
	    //assertTrue(usuarioTest.getClave2().equals(usuarioTest.getClave()));
		assertFalse(usuarioTest.getClave2().equals(usuarioTest.getClave()));
			
		}
    
}
