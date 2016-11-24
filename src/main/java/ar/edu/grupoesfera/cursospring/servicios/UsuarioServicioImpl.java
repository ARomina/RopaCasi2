package ar.edu.grupoesfera.cursospring.servicios;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;


import ar.edu.grupoesfera.cursospring.modelo.Usuario;


@Service("serviciousuario")
public class UsuarioServicioImpl implements UsuarioServicio{

	private Set<Usuario> usuarios = new TreeSet<Usuario>();
	
	/*GUARDAR USUARIO EXISTENTE*/
	public void guardaUsuarioExistente(Usuario usuario){
	      for(Iterator<Usuario> it = usuarios.iterator(); it.hasNext();){
	    	  Usuario cada = it.next();
	    		if(usuario.geteMail().equals(cada.geteMail())){
	    			usuario.seteMail(cada.geteMail());
	    			usuario.setNombreYapellido(cada.getNombreYapellido());
	    			usuario.setDni(cada.getDni());
	    			usuario.setDomicilio(cada.getDomicilio());
	    			usuario.setTelefono(cada.getTelefono());
	    			usuario.setFechaNacimiento(cada.getFechaNacimiento());
				    usuario.setClave(cada.getClave());
					usuario.setTipo(cada.getTipo());	
	          }
	      }
	}
	
	/*ALTA DE USUARIO*/
	public Boolean altaUsuario(Usuario usuario)throws Exception{
  		if(this.usuarios.contains(usuario)){
        	throw new Exception("EL USUARIO YA EXISTE"); 
        }
        else{
        	this.usuarios.add(usuario);  
        	return true;
        } 
    }
	
	/*LISTADO DE PRODUCTOS*/
	public Set<Usuario> verUsuarios(){
		return this.usuarios;
	}
	
	/*BAJA DE USUARIO*/
	public Boolean bajaUsuario(Usuario usuario)throws Exception{
        if(this.usuarios.contains(usuario)){
        	this.usuarios.remove(usuario);
        	return true;
        }
        else{
        	throw new Exception("EL USUARIO NO EXISTE");      	
        }
    }

	/*MODIFICACION DE USUARIO*/
	public void modificacionUsuario(Usuario usuario){
            for(Iterator<Usuario> it = usuarios.iterator(); it.hasNext();){
  	    	  Usuario cada = it.next();
	    		if(cada.geteMail().equals(usuario.geteMail())){
	    			cada.seteMail(usuario.geteMail());
	    			cada.setNombreYapellido(usuario.getNombreYapellido());
	    			cada.setDni(usuario.getDni());
	    			cada.setDomicilio(usuario.getDomicilio());
	    			cada.setTelefono(usuario.getTelefono());
	    			cada.setFechaNacimiento(usuario.getFechaNacimiento());
					cada.setClave(usuario.getClave());
					cada.setTipo(usuario.getTipo());
            }
          }
    }

	/*BUSCAR USUARIO */
	public Usuario buscaUsuario(Usuario usuario){
	      for(Iterator<Usuario> it = usuarios.iterator(); it.hasNext();){
	    	  Usuario cada = it.next();
	    		if(usuario.geteMail().equals(cada.geteMail())){
	    			usuario.seteMail(cada.geteMail());
	    			usuario.setNombreYapellido(cada.getNombreYapellido());
	    			usuario.setDni(cada.getDni());
	    			usuario.setDomicilio(cada.getDomicilio());
	    			usuario.setTelefono(cada.getTelefono());
	    			usuario.setFechaNacimiento(cada.getFechaNacimiento());
				    usuario.setClave(cada.getClave());
					usuario.setTipo(cada.getTipo());	
	          }
	      }
	      return usuario;
	}
	
	/*VALIDAR USUARIO*/
	public Usuario validarUsuario(String emaillog, String clavelog) {
	      for(Iterator<Usuario> it = usuarios.iterator(); it.hasNext();){
	    	  Usuario cada = it.next();
	    	  if(emaillog.equals(cada.geteMail()) && clavelog.equals(cada.getClave())){
	    		  return cada; 
	    	  }
	      }
		return null;
	}
	
	/*ROLES DE USUARIOS*/
	public Integer rolesUsuario(Usuario usuario){

	if (usuario.getTipo().equals("Administrador")) {			
		return 1;				
	}
	if (usuario.getTipo().equals("Usuario")) {
		return 2;
	}
	return null;
	}

	//Getters y Setters
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
