package ar.edu.grupoesfera.cursospring.controladores;

import java.util.Iterator;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.servicios.ProductoServicio;
//import ar.edu.grupoesfera.cursospring.modelo.ColeccionListaDeseos;
//import ar.edu.grupoesfera.cursospring.modelo.ColeccionProducto;
import ar.edu.grupoesfera.cursospring.modelo.Producto;
import ar.edu.grupoesfera.cursospring.servicios.ListaDeseosServicio;

@RestController
public class ControladorListaDeseos extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Inject
	private ProductoServicio servicioproducto;
	@Inject
	private ListaDeseosServicio servicioListaDeseos;
	
	//Si se entra directamente a la lista de deseos (sin login)
	@RequestMapping (value = "/verListaDeseos")
	public ModelAndView errorCarrito(@ModelAttribute("producto")Producto producto){
		String info = "Para ver la Lista de Deseos tienes que iniciar sesión";
		ModelMap modelo = new ModelMap();
		modelo.put("info",info);
		return new ModelAndView ("error", modelo);	
		}
	
	//Agregar a la lista de deseos el producto indicado
	@RequestMapping(value = "/agregarAListaDeseos", method = RequestMethod.GET)
	public ModelAndView agregarProductoAListaDeseos(@ModelAttribute("producto")Producto producto,
			                                        @RequestParam(value="id")Integer id){
		ModelMap modelo = new ModelMap();
		//ColeccionProducto coleccionproducto = ColeccionProducto.getInstance();
		//ColeccionListaDeseos servicioListaDeseos = ColeccionListaDeseos.getInstance();
		//String info = "";
		//String info2="";
		try{
		   servicioproducto.buscaProducto(producto);
		   for(Iterator<Producto> it = servicioproducto.verProductos().iterator(); it.hasNext();){
		      Producto cada = it.next();
		      if(producto.getId().equals(cada.getId())){
		         servicioListaDeseos.ponerProductoLista(cada);
		   } 
		}
		   //info="EXISTE PRODUCTO";
		}catch(Exception e){
			e.getMessage();
		   //info= "PRODUCTO NO ENCONTRADO";
		}
		
		//Comprobacion de lista vacia
	    /*if(servicioListaDeseos.listaDeseosVacia()){
		   info2="LISTA VACIA";
		}
	    else{
			info2="LISTA NO VACIA";
		}*/
		
		//modelo.put("info", info);
		//modelo.put("info2", info2);
		modelo.put("servicioListaDeseos", servicioListaDeseos.verProductosListaDeseos());
		return new ModelAndView("verMiListaDeseos", modelo);
	}
	
	//Ver pagina de confirmacion de quitar producto de la lista
	@RequestMapping(value = "/quitarListaDeseos", method = RequestMethod.GET)
	public ModelAndView quitarProductoListaDeseos(@ModelAttribute("producto")Producto producto,
                                                  @RequestParam(value="id")Integer id){
         ModelMap modelo = new ModelMap();
         //ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
 		 //ColeccionListaDeseos servicioListaDeseos = ColeccionListaDeseos.getInstance();
 		 String info = "";
 		 servicioListaDeseos.guardaProductoLista(producto);
 		 servicioListaDeseos.verProductosListaDeseos();
 		 modelo.put("info", info);
 		 return new ModelAndView ("quitarListaDeseos", modelo);
	}
	
	//Quitar producto indicado de la lista de deseos
	@RequestMapping(value = "/quitarListaDeseosConfirmado", method = RequestMethod.GET)
	public ModelAndView quitarProductoListaDeseosConfirmado(@ModelAttribute("producto")Producto producto,
                                                            @RequestParam(value="id")Integer id){
         ModelMap modelo = new ModelMap();
         //ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
 		 //ColeccionListaDeseos servicioListaDeseos = ColeccionListaDeseos.getInstance();
 		 servicioListaDeseos.guardaProductoLista(producto);
 		 String info = "";
 		 try{
			servicioListaDeseos.quitarProductoLista(producto);
		    info = "SE HA QUITADO EL PRODUCTO DE LA LISTA DE DESEOS";
		 }catch(Exception e){
			info = "NO SE PUDO QUITAR EL PRODUCTO";
		 }
 		 modelo.put("info", info);
 		 return new ModelAndView ("quitarListaDeseosConfirmado", modelo);
	}
	
	//VerListaDeseos
	@RequestMapping(value = "/verMiListaDeseos", method = RequestMethod.GET)
	public ModelAndView agregarVerProductoAListaDeseos(@ModelAttribute("producto")Producto producto){
		ModelMap modelo = new ModelMap();
		//ColeccionProducto coleccionproducto = ColeccionProducto.getInstance();
		//ColeccionListaDeseos servicioListaDeseos = ColeccionListaDeseos.getInstance();
		//String info = "";
		//String info2="";
		try{
		   servicioproducto.buscaProducto(producto);
		   for(Iterator<Producto> it = servicioproducto.verProductos().iterator(); it.hasNext();){
		      Producto cada = it.next();
		      if(producto.getId().equals(cada.getId())){
		         servicioListaDeseos.ponerProductoLista(cada);
		   } 
		}
		   //info = "EXISTE PRODUCTO";
		}catch(Exception e){
			e.getMessage();
		   //info = "PRODUCTO NO ENCONTRADO";
		}
		
		//Comprobacion de lista vacia
	    /* if(servicioListaDeseos.listaDeseosVacia()){
	        info2="LISTA VACIA";
		}
	    else{
			info2="LISTA NO VACIA";
		}*/
		
		//modelo.put("info", info);
		//modelo.put("info2", info2);
		modelo.put("servicioListaDeseos", servicioListaDeseos.verProductosListaDeseos());
		return new ModelAndView("verMiListaDeseos", modelo);
	}

	//Getters y Setters
	public ProductoServicio getServicioproducto() {
		return servicioproducto;
	}

	public void setServicioproducto(ProductoServicio servicioproducto) {
		this.servicioproducto = servicioproducto;
	}

	public ListaDeseosServicio getServicioListaDeseos() {
		return servicioListaDeseos;
	}

	public void setServicioListaDeseos(ListaDeseosServicio servicioListaDeseos) {
		this.servicioListaDeseos = servicioListaDeseos;
	}

}