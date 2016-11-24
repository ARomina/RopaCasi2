package ar.edu.grupoesfera.cursospring.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//import ar.edu.grupoesfera.cursospring.modelo.ColeccionProducto;
import ar.edu.grupoesfera.cursospring.modelo.Producto;
//import ar.edu.grupoesfera.cursospring.modelo.Stock;
import ar.edu.grupoesfera.cursospring.servicios.ProductoServicio;
import ar.edu.grupoesfera.cursospring.servicios.StockServicio;

@RestController
public class ControladorStock extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private ProductoServicio servicioproducto;
	@Inject
	private StockServicio serviciostock;
	
	/*LISTADO DE STOCK*/
	@RequestMapping (value = "/verStock")
	public ModelAndView cargaVerStock(@ModelAttribute ("producto")Producto producto){
		ModelMap modelo = new ModelMap();
		//Stock serviciostock = Stock.getInstance();
	    modelo.put("serviciostock", serviciostock.obtenerStock());
		return new ModelAndView ("verStock", modelo);
	}

	/*ALTA DE PRODUCTO EN STOCK*/
	@RequestMapping (value = "/altaStock")
	public ModelAndView altaStock(){
		String info="ALTA DE PRODUCTO EN STOCK";
		ModelMap modelo = new ModelMap();
	    modelo.put("info",info);
		return new ModelAndView ("altaStock0", modelo);
	}
	
	/*BUSCA PRODUCTO PARA DAR DE ALTA EN EL STOCK*/
	@RequestMapping (value = "/altaStockBusca", method = RequestMethod.POST)
	public ModelAndView altaStockBusca(@ModelAttribute ("producto")Producto producto){
		String info;
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		//Stock serviciostock = Stock.getInstance();
		ModelMap modelo = new ModelMap();
		try{
			servicioproducto.buscaProducto(producto);
			servicioproducto.verProductos();
			info="CONFIRMAR ALTA DE PRODUCTO EN STOCK";
			}catch(Exception e){
				info= e.getMessage();
			    modelo.put("info",info);
				return new ModelAndView ("altaStock0", modelo);
			}
		Integer cantidad = serviciostock.obtenerCantidad(producto);
	    modelo.put("info",info);
	    modelo.put("serviciostock", serviciostock.obtenerStock());
	    modelo.put("cantidad", cantidad);
		return new ModelAndView ("altaStock", modelo);
	}
	
	/*ALTA DE PRODUCTO EN EL STOCK*/
	@RequestMapping (value = "/altaStockConfirma", method = RequestMethod.GET)
	public ModelAndView altaStockConfirma(@ModelAttribute ("producto")Producto producto){
		String info;
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		//Stock serviciostock = Stock.getInstance();
		ModelMap modelo = new ModelMap();
		try{
			servicioproducto.buscaProducto(producto);
			serviciostock.agregarProducto(producto);
			servicioproducto.verProductos();
			info="ALTA DE PRODUCTO EN STOCK EXITOSA";
			}catch(Exception e){
				info= e.getMessage();
			}
		Integer cantidad = serviciostock.obtenerCantidad(producto);
	    modelo.put("info",info);
	    modelo.put("serviciostock", serviciostock.obtenerStock());
	    modelo.put("cantidad", cantidad);
		return new ModelAndView ("altaStock", modelo);
	}
	
	/*BAJA DE PRODUCTO EN STOCK*/
	@RequestMapping (value = "/bajaStock")
	public ModelAndView bajaStock(){
		String info="BAJA DE PRODUCTO EN STOCK";
		ModelMap modelo = new ModelMap();
	    modelo.put("info",info);
		return new ModelAndView ("bajaStock0", modelo);
	}
	
	/*BUSCA PRODUCTO PARA DAR DE BAJA DEL STOCK*/
	@RequestMapping (value = "/bajaStockBusca", method = RequestMethod.POST)
	public ModelAndView bajaStockBusca(@ModelAttribute ("producto")Producto producto){
		String info;
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		//Stock serviciostock = Stock.getInstance();
		ModelMap modelo = new ModelMap();
		try{
			servicioproducto.buscaProducto(producto);
			servicioproducto.verProductos();
			info="CONFIRMAR BAJA DE PRODUCTO EN STOCK";
			}catch(Exception e){
				info= e.getMessage();
			    modelo.put("info",info);
				return new ModelAndView ("bajaStock0", modelo);
			}
		Integer cantidad = serviciostock.obtenerCantidad(producto);
	    modelo.put("info",info);
	    modelo.put("serviciostock", serviciostock.obtenerStock());
	    modelo.put("cantidad", cantidad);
		return new ModelAndView ("bajaStock", modelo);
	}
	
	/*BAJA DE PRODUCTO EN EL STOCK*/
	@RequestMapping (value = "/bajaStockConfirma", method = RequestMethod.GET)
	public ModelAndView bajaStockConfirma(@ModelAttribute ("producto")Producto producto){
		String info;
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		//Stock serviciostock = Stock.getInstance();
		ModelMap modelo = new ModelMap();
		try{
			servicioproducto.buscaProducto(producto);
			serviciostock.eliminarProducto(producto);
			servicioproducto.verProductos();
			info="BAJA DE PRODUCTO EN STOCK EXITOSA";
			}catch(Exception e){
				info= e.getMessage();
			}
		Integer cantidad = serviciostock.obtenerCantidad(producto);
	    modelo.put("info",info);
	    modelo.put("serviciostock", serviciostock.obtenerStock());
	    modelo.put("cantidad", cantidad);
		return new ModelAndView ("bajaStock", modelo);
	}
	
	
	/*ALTA DE STOCK EN PRODUCTO*/
	@RequestMapping (value = "/agregarStock")
	public ModelAndView cargaAgregarStock(@ModelAttribute ("producto")Producto producto){
		ModelMap modelo = new ModelMap();
		//Stock serviciostock = Stock.getInstance();
	    modelo.put("serviciostock", serviciostock.obtenerStock());
		return new ModelAndView ("agregarStock", modelo);
	}

	/*MUESTRA PRODUCTO EN STOCK PARA INGRESAR CANTIDAD NUEVA*/
	@RequestMapping (value = "/altaStockCantidad", method = RequestMethod.GET)
	public ModelAndView altaStockCantidad(@ModelAttribute ("producto")Producto producto,
			                              @RequestParam(value="id")Integer id){
		String info;
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		//Stock serviciostock = Stock.getInstance();
		ModelMap modelo = new ModelMap();
		try{
			servicioproducto.buscaProducto(producto);
			servicioproducto.verProductos();
			info="ALTA DE STOCK EN PRODUCTO";
			}catch(Exception e){
				info= e.getMessage();
			}
		Integer cantidad = serviciostock.obtenerCantidad(producto);
	    modelo.put("info",info);
	    modelo.put("serviciostock", serviciostock.obtenerStock());
	    modelo.put("cantidad", cantidad);
		return new ModelAndView ("altaStockCantidad", modelo);
	}
	
	/*AGREGA NUEVA CANTIDAD AL PRODUCTO EN STOCK*/
	@RequestMapping (value = "/altaStockCantidadOk", method = RequestMethod.POST)
	public ModelAndView altaStockCantidadOk(Producto producto, Integer cantidad, Integer cantidadanterior){
		String info;
		String columna = "AGREGADO";
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		//Stock serviciostock = Stock.getInstance();
		ModelMap modelo = new ModelMap();
		try{
			servicioproducto.buscaProducto(producto);
			serviciostock.agregarStock(producto, cantidad);
			servicioproducto.verProductos();
			info="ALTA DE STOCK EN PRODUCTO EXITOSA";
			}catch(Exception e){
				info= e.getMessage();
			}
		Integer actual = serviciostock.obtenerCantidad(producto);
	    modelo.put("info",info);
	    modelo.put("columna",columna);
	    modelo.put("serviciostock", serviciostock.obtenerStock());
	    modelo.put("cantidadanterior", cantidadanterior);
	    modelo.put("nuevacantidad", cantidad);
	    modelo.put("actual", actual);
		return new ModelAndView ("altaStockCantidadOk", modelo);
	}
	
	/*REVERTIR AGREGA NUEVA CANTIDAD AL PRODUCTO EN STOCK*/
	@RequestMapping (value = "/revierteStockCantidad", method = RequestMethod.GET)
	public ModelAndView revierteStockCantidad(Producto producto, 
											  @RequestParam(value="agregada")Integer agregada, 
											  @RequestParam(value="actual")Integer actual){
		String info;
		String columna = "REVERTIDO";
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		//Stock serviciostock = Stock.getInstance();
		ModelMap modelo = new ModelMap();
		try{
			servicioproducto.buscaProducto(producto);
			serviciostock.revertirStock(producto, agregada);
			servicioproducto.verProductos();
			info=" REVERTIR ALTA DE STOCK EN PRODUCTO EXITOSA";
			}catch(Exception e){
				info= e.getMessage();
			}
		Integer nueva = serviciostock.obtenerCantidad(producto);
	    modelo.put("info",info);
	    modelo.put("columna",columna);
	    modelo.put("serviciostock", serviciostock.obtenerStock());
	    modelo.put("cantidadanterior", actual);
	    modelo.put("nuevacantidad", agregada);
	    modelo.put("actual", nueva);
		return new ModelAndView ("altaStockCantidadOk", modelo);
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
}
