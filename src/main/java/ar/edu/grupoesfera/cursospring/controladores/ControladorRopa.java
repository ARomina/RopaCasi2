package ar.edu.grupoesfera.cursospring.controladores;

import javax.inject.Inject;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.modelo.ColeccionCategoria;
import ar.edu.grupoesfera.cursospring.modelo.ColeccionColor;
//import ar.edu.grupoesfera.cursospring.modelo.ColeccionProducto;
import ar.edu.grupoesfera.cursospring.modelo.ColeccionTalle;
import ar.edu.grupoesfera.cursospring.modelo.Producto;
import ar.edu.grupoesfera.cursospring.servicios.ProductoServicio;


@RestController
public class ControladorRopa {
	@Inject
	private ProductoServicio servicioproducto;
	
	/*ADMINISTRADOR*/
	@RequestMapping (value = "/administrar")
	public ModelAndView administrar(){
		ModelMap modelo = new ModelMap();
		return new ModelAndView ("administrar", modelo);
	}
	
	/*ADMINISTRADOR CATEGORIA/COLOR/TALLE*/
	@RequestMapping (value = "/administrar2")
	public ModelAndView administrar2(){
		ColeccionCategoria categorias = ColeccionCategoria.getInstance();
		ColeccionColor colores = ColeccionColor.getInstance();
		ColeccionTalle talles = ColeccionTalle.getInstance();
		ModelMap modelo = new ModelMap();
		modelo.put("categorias", categorias.listaCategoria());
		modelo.put("colores", colores.listaColor());
		modelo.put("talles", talles.listaTalle());
		return new ModelAndView ("administrar2", modelo);
	}
	
	/*HOME*/
	@RequestMapping (value = "/home")
	public ModelAndView home(@ModelAttribute("producto")Producto producto){
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		ModelMap modelo = new ModelMap();
		modelo.put("servicioproducto", servicioproducto.verProductosNovedades(producto));
		return new ModelAndView ("home", modelo);
	}
	
	/*ERROR*/
	@RequestMapping (value = "/error")
	public ModelAndView error(){
		ModelMap modelo = new ModelMap();
		return new ModelAndView ("error", modelo);
	}


	/*GETTERS Y SETTERS*/
	public ProductoServicio getServicioproducto() {
		return servicioproducto;
	}

	public void setServicioproducto(ProductoServicio servicioproducto) {
		this.servicioproducto = servicioproducto;
	}

}
