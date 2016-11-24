package ar.edu.grupoesfera.cursospring.controladores;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//import ar.edu.grupoesfera.cursospring.modelo.ColeccionProducto;
//import ar.edu.grupoesfera.cursospring.modelo.ColeccionUsuario;
import ar.edu.grupoesfera.cursospring.modelo.Producto;
import ar.edu.grupoesfera.cursospring.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.modelo.ValidadorUsuario;
import ar.edu.grupoesfera.cursospring.servicios.ProductoServicio;
import ar.edu.grupoesfera.cursospring.servicios.UsuarioServicio;

@RestController
public class ControladorUsuario extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private UsuarioServicio serviciousuario;
	@Inject
	private ProductoServicio servicioproducto;

	/*ALTA USUARIO*/
	@RequestMapping (value = "/altaUsuFormulario")
	public ModelAndView altaUsuFormulario(@ModelAttribute("usuario")Usuario usuario){
		ModelMap modelo = new ModelMap();
		return new ModelAndView ("altaUsuFormulario", modelo);
	}
	
	@RequestMapping (value = "/altaUsuConfirma")
	public ModelAndView altaUsuConfirma(@ModelAttribute("usuario")Usuario usuario, BindingResult result){

		String info;
		//ColeccionUsuario serviciousuario = ColeccionUsuario.getInstance();
		ModelMap modelo = new ModelMap();
		
		ValidadorUsuario validadorusuario = new ValidadorUsuario();
		validadorusuario.validate(usuario, result);
		  if (result.hasErrors()) {
			  return new ModelAndView ("altaUsuFormulario", modelo);
			  }
		try{
			serviciousuario.altaUsuario(usuario);
		info="ALTA DE USUARIO EXITOSA";
		}catch(Exception e){
			serviciousuario.guardaUsuarioExistente(usuario);
			info= e.getMessage();
		}
		modelo.put("info", info);
		return new ModelAndView ("altaUsuConfirma", modelo);
	}
	
	/*LISTADO DE USUARIOS*/
	@RequestMapping (value = "/verUsuarios")
	public ModelAndView verUsuarios(@ModelAttribute("usuario")Usuario usuario){
		ModelMap modelo = new ModelMap();
		//ColeccionUsuario serviciousuario = ColeccionUsuario.getInstance();
		modelo.put("serviciousuario", serviciousuario.verUsuarios());
		return new ModelAndView ("verUsuarios", modelo);
	}

	/*BAJA Y MODIFICACION DE USUARIO*/
	@RequestMapping (value = "/bajaOmodifUsu")
	public ModelAndView bajaOmodifUsu(@ModelAttribute("usuario")Usuario usuario){
		ModelMap modelo = new ModelMap();
		//ColeccionUsuario serviciousuario = ColeccionUsuario.getInstance();
		modelo.put("usuarios", serviciousuario.verUsuarios());
		return new ModelAndView ("/bajaOmodifUsu", modelo);
	}
	
	/*BAJA DE USUARIO*/
	@RequestMapping (value = "/bajaUsuConfirma")
	public ModelAndView bajaProConfirma(@ModelAttribute("usuario")Usuario usuario,
								              @RequestParam (value="eMail")String eMail){
		//ColeccionUsuario serviciousuario = ColeccionUsuario.getInstance();
		ModelMap modelo = new ModelMap();
		serviciousuario.guardaUsuarioExistente(usuario);
		modelo.put("nombreYapellido",usuario.getNombreYapellido());
		modelo.put("dni",usuario.getDni());	
		modelo.put("domicilio",usuario.getDomicilio());
		modelo.put("telefono",usuario.getTelefono());
		modelo.put("fechaNacimiento",usuario.getFechaNacimiento());
		modelo.put("eMail",usuario.geteMail());
		modelo.put("clave",usuario.getClave());
		modelo.put("tipo",usuario.getTipo());		
		return new ModelAndView ("/bajaUsuConfirma", modelo);
	}
	
	@RequestMapping (value = "/bajaUsuOk")
	public ModelAndView bajaUsuOk(@ModelAttribute("usuario")Usuario usuario){
		String info;
		String boton="Eliminar Otro";
		ModelMap modelo = new ModelMap();
		//ColeccionUsuario serviciousuario = ColeccionUsuario.getInstance();
		try{
			serviciousuario.bajaUsuario(usuario);
		info="BAJA DE USUARIO EXITOSA";
		}catch(Exception e){
			info= e.getMessage();
		}
		modelo.put("info", info);
		modelo.put("boton", boton);
		modelo.put("usuarios", serviciousuario.verUsuarios());
		return new ModelAndView ("/bajaOmodifUsuOk", modelo);
	}
	
	/*MODIFICACION DE USUARIO*/
	@RequestMapping (value = "/modifUsuConfirma", method = RequestMethod.GET)
	public ModelAndView modifUsuConfirma(@ModelAttribute("usuario")Usuario usuario,
								              @RequestParam (value="eMail")String eMail){
		String info="MODIFICACIÓN DE USUARIO";
		String boton="Modificar";
		ModelMap modelo = new ModelMap();
		//ColeccionUsuario serviciousuario = ColeccionUsuario.getInstance();
		serviciousuario.guardaUsuarioExistente(usuario);
		modelo.put("info", info);
		modelo.put("boton", boton);
		return new ModelAndView ("/modifUsuConfirma", modelo);
	}
	
	@RequestMapping (path = "/modifUsuOk")
	public ModelAndView modifUsuOk(@ModelAttribute("usuario")Usuario usuario, BindingResult result){
		String info;
		String boton="Modificar Otro";
		ModelMap modelo = new ModelMap();
		//ColeccionUsuario serviciousuario = ColeccionUsuario.getInstance();
		
		ValidadorUsuario validadorusuario = new ValidadorUsuario();
		validadorusuario.validate(usuario, result);
		  if (result.hasErrors()) {
			  return new ModelAndView ("modifUsuConfirma", modelo);
			  }
		try{
			serviciousuario.altaUsuario(usuario);
			info="MODIFICACION DE USUARIO RECHAZADA";
		}catch (Exception e){
			serviciousuario.modificacionUsuario(usuario);	
			info="MODIFICACION DE USUARIO EXITOSA";			
		}
		modelo.put("info", info);
		modelo.put("boton", boton);
		modelo.put("usuarios", serviciousuario.verUsuarios());
		return new ModelAndView ("/bajaOmodifUsuOk", modelo);
	}

	/*REGISTRO DE USUARIO*/
	@RequestMapping ("/registro")
	public ModelAndView cargaFormRegistro(@ModelAttribute("usuario")Usuario usuario){
		ModelMap modelo = new ModelMap();
		return new ModelAndView ("registro", modelo);
	}
	
	@RequestMapping (value = "/regUsuConfirma")
	public ModelAndView regUsuConfirma(@ModelAttribute("usuario")Usuario usuario, BindingResult result){
		String info;
		//ColeccionUsuario serviciousuario = ColeccionUsuario.getInstance();
		ModelMap modelo = new ModelMap();
		
		ValidadorUsuario validadorusuario = new ValidadorUsuario();
		validadorusuario.validate(usuario, result);
		  if (result.hasErrors()) {
			  return new ModelAndView ("registro", modelo);
			  }
		try{
			serviciousuario.altaUsuario(usuario);
			info="REGISTRO EXITOSO";
		}catch(Exception e){
			usuario.setNombreYapellido(null);
			usuario.setDni(null);
			usuario.setDomicilio(null);
			usuario.setFechaNacimiento(null);
			usuario.setTelefono(null);
			usuario.geteMail();
			usuario.setClave(null);
			info= e.getMessage();
		}
		modelo.put("info", info);
		return new ModelAndView ("regUsuConfirma", modelo);
	}

	/*LOGIN*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, 
			                  @ModelAttribute("usuario")Usuario usuario,
			                  @ModelAttribute("producto")Producto producto) throws ServletException, IOException {
		response.setContentType("text/html");
		//ColeccionUsuario serviciousuario = ColeccionUsuario.getInstance();
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		ModelMap modelo = new ModelMap();
		Usuario miusuario = serviciousuario.validarUsuario(request.getParameter("emaillog"), request.getParameter("clavelog"));
		
		if(miusuario!=null){
			Integer rol = serviciousuario.rolesUsuario(miusuario);
			HttpSession session = request.getSession(true); 
			session.setAttribute("user", request.getParameter("emaillog"));
			session.setMaxInactiveInterval(180);
			if (rol==1) {			
				return new ModelAndView("administrar", modelo);				
			}
			if (rol==2) {
				modelo.put("servicioproducto", servicioproducto.verProductosNovedades(producto));
				return new ModelAndView("home", modelo);
			}		
		}
		String info="Usuario y/o Contraseña Incorrectos";
		modelo.put("info", info);
		return new ModelAndView("/error", modelo);
	}
	
	/*LOGOUT*/
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, 
							   @ModelAttribute("usuario")Usuario usuario,
							   @ModelAttribute("producto")Producto producto) throws ServletException, IOException {
		response.setContentType("text/html");
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		ModelMap modelo = new ModelMap();
		HttpSession session = request.getSession(true);
		session.setAttribute("user", null);
		session.removeAttribute("user");
		session.getMaxInactiveInterval();
		modelo.put("servicioproducto", servicioproducto.verProductosNovedades(producto));
		return new ModelAndView("home", modelo);
	}
	
	/*GETTERS Y SETERS*/

	public UsuarioServicio getServiciousuario() {
		return serviciousuario;
	}

	public void setServiciousuario(UsuarioServicio serviciousuario) {
		this.serviciousuario = serviciousuario;
	}

	public ProductoServicio getServicioproducto() {
		return servicioproducto;
	}

	public void setServicioproducto(ProductoServicio servicioproducto) {
		this.servicioproducto = servicioproducto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
