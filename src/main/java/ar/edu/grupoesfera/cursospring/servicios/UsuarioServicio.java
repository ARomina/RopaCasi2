package ar.edu.grupoesfera.cursospring.servicios;

import java.util.Set;

import ar.edu.grupoesfera.cursospring.modelo.Usuario;

public interface UsuarioServicio {

	public void guardaUsuarioExistente(Usuario usuario);
	public Boolean altaUsuario(Usuario usuario)throws Exception;
	public Set<Usuario> verUsuarios();
	public Boolean bajaUsuario(Usuario usuario)throws Exception;
	public void modificacionUsuario(Usuario usuario);
	public Usuario buscaUsuario(Usuario usuario);
	public Usuario validarUsuario(String emaillog, String clavelog);
	public Integer rolesUsuario(Usuario usuario);
	
}
