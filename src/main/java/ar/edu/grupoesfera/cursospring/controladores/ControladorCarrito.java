package ar.edu.grupoesfera.cursospring.controladores;


import javax.inject.Inject;
import javax.servlet.http.HttpServlet;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//import ar.edu.grupoesfera.cursospring.modelo.Carrito;
//import ar.edu.grupoesfera.cursospring.modelo.ColeccionProducto;
import ar.edu.grupoesfera.cursospring.modelo.Producto;
//import ar.edu.grupoesfera.cursospring.modelo.Stock;
import ar.edu.grupoesfera.cursospring.servicios.CarritoServicio;
import ar.edu.grupoesfera.cursospring.servicios.ProductoServicio;
import ar.edu.grupoesfera.cursospring.servicios.StockServicio;

@RestController
public class ControladorCarrito extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private ProductoServicio servicioproducto;
	@Inject
	private StockServicio serviciostock;
	@Inject
	private CarritoServicio serviciocarrito;

	/*CARRITO DE COMPRAS*/
	@RequestMapping (value="/carrito{id}")
	public ModelAndView cargaCarrito(@PathVariable Integer id,
									 @ModelAttribute ("producto")Producto producto){
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		ModelMap modelo = new ModelMap();
		servicioproducto.guardaProductoExistente(producto);
		return new ModelAndView ("carrito", modelo);
			}

	@RequestMapping (value="/carrito")
	public ModelAndView errorCarrito(@ModelAttribute ("producto")Producto producto){
		String info = null;
		ModelMap modelo = new ModelMap();
		info="Debes Iniciar Sesión";
		modelo.put("info",info);
		return new ModelAndView ("error", modelo);	
		}
	
	/*AGREGAR AL CARRITO*/
	@RequestMapping (value="/agregarAlCarrito", method = RequestMethod.POST)
	public ModelAndView agregarAlCarrito(@RequestParam(value="id") Integer id,
	                                     @RequestParam(value="unidades") Integer unidades,
	                                     @ModelAttribute(value="producto")Producto producto){
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		//Carrito serviciocarrito = Carrito.getInstance();
		servicioproducto.guardaProductoExistente(producto);
		//Stock serviciostock = Stock.getInstance();
		ModelMap modelo = new ModelMap();
        
		String info = "CARRITO DE COMPRAS";
        Integer cantidad = serviciostock.obtenerCantidad(producto);
		try{
			if(serviciostock.obtenerCantidad(producto)!= 0 && unidades <= cantidad){
				serviciocarrito.agregarProductosAlcarrito(producto, unidades);
				serviciostock.comprarProducto(producto, unidades);
				servicioproducto.verProductos();
				float total = producto.getPrecio()*unidades;
				info="ALTA DE PRODUCTO EN CARRITO EXITOSA";
				modelo.put("serviciocarrito", serviciocarrito.listadoDeCarrito());
			    modelo.put("compradas", unidades);
			    modelo.put("total", total);
				modelo.put("info", info);	
				return new ModelAndView ("carrito", modelo);
			}else{
				info="EL STOCK DISPONIBLE NO ES SUFICIENTE";
			}
			}catch(Exception e){
				info="EL STOCK DISPONIBLE NO ES SUFICIENTE";
				modelo.put("info", info);	
				return new ModelAndView ("carrito", modelo);
			}
		modelo.put("info", info);	
		return new ModelAndView ("carrito", modelo);
	}
	
	/*LISTADO DE CARRITO*/
	@RequestMapping (value = "/miCarrito")
	public ModelAndView cargaVerCarrito(@ModelAttribute ("producto")Producto producto){
		ModelMap modelo = new ModelMap();
		//Carrito serviciocarrito = Carrito.getInstance();
	    modelo.put("serviciocarrito", serviciocarrito.listadoDeCarrito());
	    modelo.put("estado", "Ver ruta de envío");
		return new ModelAndView ("carritoMio", modelo);
	}
	
	/*ELIMINAR PRODUCTO DEL CARRITO*/
	@RequestMapping (value = "/bajaCarrito", method = RequestMethod.GET)
	public ModelAndView eliminarDelCarrito(@RequestParam(value="id") Integer id,
	                                       @RequestParam(value="unidades") Integer unidades,
	                                       @ModelAttribute(value="producto")Producto producto){
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		//Carrito serviciocarrito = Carrito.getInstance();
		servicioproducto.guardaProductoExistente(producto);
		//Stock serviciostock = Stock.getInstance();
		ModelMap modelo = new ModelMap();
        
		String info = "CARRITO DE COMPRAS";

				serviciocarrito.eliminarProductosDelCarrito(producto, unidades);
				serviciostock.agregarStock(producto, unidades);
				servicioproducto.verProductos();
				info="BAJA DE PRODUCTO EN CARRITO EXITOSA";
				modelo.put("info", info);	
			return new ModelAndView ("carritoMio", modelo);
	}
	
	/*SEGUIR RECORRIDO*/
	@RequestMapping (value = "/seguir")
	public ModelAndView seguir(@ModelAttribute ("producto")Producto producto){
		ModelMap modelo = new ModelMap();
		return new ModelAndView ("/seguir", modelo);
	}
	
	/*GETTERS Y SETERS*/
	public ProductoServicio getServicioproducto() {
		return servicioproducto;
	}

	public void setServicioproducto(ProductoServicio servicioproducto) {
		this.servicioproducto = servicioproducto;
	}

	public StockServicio getServiciostock() {
		return serviciostock;
	}

	public void setServiciostock(StockServicio serviciostock) {
		this.serviciostock = serviciostock;
	}

	public CarritoServicio getServiciocarrito() {
		return serviciocarrito;
	}

	public void setServiciocarrito(CarritoServicio serviciocarrito) {
		this.serviciocarrito = serviciocarrito;
	}
}
