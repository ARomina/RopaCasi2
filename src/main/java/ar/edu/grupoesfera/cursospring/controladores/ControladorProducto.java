package ar.edu.grupoesfera.cursospring.controladores;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.grupoesfera.cursospring.modelo.Categoria;
import ar.edu.grupoesfera.cursospring.modelo.ColeccionCategoria;
import ar.edu.grupoesfera.cursospring.modelo.ColeccionColor;
//import ar.edu.grupoesfera.cursospring.modelo.ColeccionProducto;
import ar.edu.grupoesfera.cursospring.modelo.ColeccionTalle;
import ar.edu.grupoesfera.cursospring.modelo.Color;
import ar.edu.grupoesfera.cursospring.modelo.Producto;
//import ar.edu.grupoesfera.cursospring.modelo.Stock;
import ar.edu.grupoesfera.cursospring.modelo.Talle;
import ar.edu.grupoesfera.cursospring.modelo.ValidadorProducto;
import ar.edu.grupoesfera.cursospring.servicios.ProductoServicio;
import ar.edu.grupoesfera.cursospring.servicios.StockServicio;

@RestController
@MultipartConfig
public class ControladorProducto extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private ProductoServicio servicioproducto;
	private StockServicio serviciostock;
	
	/*ALTA PRODUCTO*/
	@RequestMapping (value = "/altaProFormulario")
	public ModelAndView altaProFormulario(@ModelAttribute("producto")Producto producto){
		ColeccionCategoria categorias = ColeccionCategoria.getInstance();
		ColeccionColor colores = ColeccionColor.getInstance();
		ColeccionTalle talles = ColeccionTalle.getInstance();
		ModelMap modelo = new ModelMap();
		modelo.put("categorias", categorias.listaCategoria());
		modelo.put("colores", colores.listaColor());
		modelo.put("talles", talles.listaTalle());
		return new ModelAndView ("altaProFormulario", modelo);
	}
	 
	@RequestMapping (value = "/altaProConfirma")
	public ModelAndView altaProConfirma(@ModelAttribute("producto")Producto producto, BindingResult result){
		String info;
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		ColeccionCategoria categorias = ColeccionCategoria.getInstance();
		ColeccionColor colores = ColeccionColor.getInstance();
		ColeccionTalle talles = ColeccionTalle.getInstance();
		ModelMap modelo = new ModelMap();
		modelo.put("categorias", categorias.listaCategoria());
		modelo.put("colores", colores.listaColor());
		modelo.put("talles", talles.listaTalle());
		ValidadorProducto validadorproducto = new ValidadorProducto();
		validadorproducto.validate(producto, result);
		  if (result.hasErrors()) {
			  return new ModelAndView ("altaProFormulario", modelo);
			  }
		try{
			servicioproducto.altaProducto(producto);
		info="ALTA DE PRODUCTO EXITOSA";
		}catch(Exception e){
			servicioproducto.guardaProductoExistente(producto);
			info= e.getMessage();
		}
		String rutaimagen ="images/productos"+"/"+producto.getImagenproducto().getOriginalFilename();
		modelo.put("info", info);
		modelo.put("rutaimagen", rutaimagen);
		return new ModelAndView ("altaProConfirma", modelo);
	}
	
	/*LISTADO DE PRODUCTOS*/
	@RequestMapping (value = "/verProductos")
	public ModelAndView verProductos(@ModelAttribute("producto")Producto producto){
		ModelMap modelo = new ModelMap();
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		modelo.put("servicioproducto", servicioproducto.verProductos());
		return new ModelAndView ("verProductos", modelo);
	}

	/*BAJA Y MODIFICACION DE PRODUCTO*/
	@RequestMapping (value = "/bajaOmodifPro")
	public ModelAndView bajaOmodifPro(@ModelAttribute("producto")Producto producto){
		ModelMap modelo = new ModelMap();
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		modelo.put("productos", servicioproducto.verProductos());
		return new ModelAndView ("/bajaOmodifPro", modelo);
	}
	
	/*BAJA DE PRODUCTO*/
	@RequestMapping (value = "/bajaProConfirma")
	public ModelAndView bajaProConfirma(@ModelAttribute("producto")Producto producto,
								              @RequestParam (value="id")Integer id){
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		ModelMap modelo = new ModelMap();
		servicioproducto.guardaProductoExistente(producto);
		servicioproducto.verProductos();
		return new ModelAndView ("/bajaProConfirma", modelo);
	}
	
	@RequestMapping (value = "/bajaProOk")
	public ModelAndView bajaProOk(@ModelAttribute("producto")Producto producto){
		String info;
		String boton="Eliminar Otro";
		ModelMap modelo = new ModelMap();
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		try{
			servicioproducto.bajaProducto(producto);
		info="BAJA DE PRODUCTO EXITOSA";
		}catch(Exception e){
			info= e.getMessage();
		}
		modelo.put("info", info);
		modelo.put("boton", boton);
		modelo.put("productos", servicioproducto.verProductos());
		return new ModelAndView ("/bajaOmodifProOk", modelo);
	}
	
	/*MODIFICACION DE PRODUCTO*/
	@RequestMapping (value = "/modifProConfirma", method = RequestMethod.GET)
	public ModelAndView modifProConfirma(@ModelAttribute("producto")Producto producto,
								              @RequestParam (value="id")Integer id){
		String info="MODIFICACIÓN DE PRODUCTO";
		String boton="Modificar";
		ModelMap modelo = new ModelMap();
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		servicioproducto.guardaProductoExistente(producto);
		modelo.put("info", info);
		modelo.put("boton", boton);
		return new ModelAndView ("/modifProConfirma", modelo);
	}
	
	@RequestMapping (path = "/modifProOk")
	public ModelAndView modifProOk(@ModelAttribute("producto")Producto producto){
		String info;
		String boton="Modificar Otro";
		ModelMap modelo = new ModelMap();
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		try{
			servicioproducto.altaProducto(producto);
			info="MODIFICACION DE PRODUCTO RECHAZADA";
		}catch (Exception e){
			servicioproducto.modificacionProducto(producto);	
			info="MODIFICACION DE PRODUCTO EXITOSA";			
		}
		modelo.put("info", info);
		modelo.put("boton", boton);
		modelo.put("productos", servicioproducto.verProductos());
		return new ModelAndView ("/bajaOmodifProOk", modelo);
	}

	/*ALTA Y LISTADO DE CATEGORIA*/
	@RequestMapping (value = "/altaCat", method = RequestMethod.POST)
	public ModelAndView altaCategoria(@ModelAttribute("categoria")Categoria categoria){
		ColeccionCategoria categorias = ColeccionCategoria.getInstance();
		ColeccionColor colores = ColeccionColor.getInstance();
		ColeccionTalle talles = ColeccionTalle.getInstance();
		ModelMap modelo = new ModelMap();
		categorias.altaCategoria(categoria);
		modelo.put("categorias", categorias.listaCategoria());
		modelo.put("colores", colores.listaColor());
		modelo.put("talles", talles.listaTalle());
		return new ModelAndView ("administrar2", modelo);
	}

	/*BAJA DE CATEGORIA*/
	@RequestMapping (value = "/bajaCat")
	public ModelAndView bajaCategoria(@ModelAttribute("categoria")Categoria categoria){
		ColeccionCategoria categorias = ColeccionCategoria.getInstance();
		ColeccionColor colores = ColeccionColor.getInstance();
		ColeccionTalle talles = ColeccionTalle.getInstance();
		ModelMap modelo = new ModelMap();
		categorias.bajaCategoria(categoria);
		modelo.put("categorias", categorias.listaCategoria());
		modelo.put("colores", colores.listaColor());
		modelo.put("talles", talles.listaTalle());
		return new ModelAndView ("/administrar2", modelo);
	}
	
	/*ALTA Y LISTADO DE COLOR*/
	@RequestMapping (value = "/altaCol", method = RequestMethod.POST)
	public ModelAndView altaColor(@ModelAttribute("color")Color color){
		ColeccionColor colores = ColeccionColor.getInstance();
		ColeccionCategoria categorias = ColeccionCategoria.getInstance();
		ColeccionTalle talles = ColeccionTalle.getInstance();
		ModelMap modelo = new ModelMap();
		colores.altaColor(color);
		modelo.put("colores", colores.listaColor());
		modelo.put("categorias", categorias.listaCategoria());
		modelo.put("talles", talles.listaTalle());
		return new ModelAndView ("administrar2", modelo);
	}

	/*BAJA DE COLOR*/
	@RequestMapping (value = "/bajaCol")
	public ModelAndView bajaColor(@ModelAttribute("color")Color color){
		ColeccionColor colores = ColeccionColor.getInstance();
		ColeccionCategoria categorias = ColeccionCategoria.getInstance();
		ColeccionTalle talles = ColeccionTalle.getInstance();
		ModelMap modelo = new ModelMap();
		colores.bajaColor(color);
		modelo.put("colores", colores.listaColor());
		modelo.put("categorias", categorias.listaCategoria());
		modelo.put("talles", talles.listaTalle());
		return new ModelAndView ("/administrar2", modelo);
	}
	
	/*ALTA Y LISTADO DE TALLE*/
	@RequestMapping (value = "/altaTal", method = RequestMethod.POST)
	public ModelAndView altaTalle(@ModelAttribute("talle")Talle talle){
		ColeccionTalle talles = ColeccionTalle.getInstance();
		ColeccionColor colores = ColeccionColor.getInstance();
		ColeccionCategoria categorias = ColeccionCategoria.getInstance();
		ModelMap modelo = new ModelMap();
		talles.altaTalle(talle);
		modelo.put("colores", colores.listaColor());
		modelo.put("categorias", categorias.listaCategoria());
		modelo.put("talles", talles.listaTalle());
		return new ModelAndView ("administrar2", modelo);
	}

	/*BAJA DE TALLE*/
	@RequestMapping (value = "/bajaTal")
	public ModelAndView bajaTalle(@ModelAttribute("talle")Talle talle){
		ColeccionColor colores = ColeccionColor.getInstance();
		ColeccionCategoria categorias = ColeccionCategoria.getInstance();
		ColeccionTalle talles = ColeccionTalle.getInstance();
		ModelMap modelo = new ModelMap();
		talles.bajaTalle(talle);
		modelo.put("colores", colores.listaColor());
		modelo.put("categorias", categorias.listaCategoria());
		modelo.put("talles", talles.listaTalle());
		return new ModelAndView ("/administrar2", modelo);
	}
	
	/*VISUALIZACION CATALOGO*/
	
	/*PRODUCTOS MUJERES*/
	@RequestMapping ("/productosMu")
	public ModelAndView cargaProductosMujeres(@ModelAttribute("producto")Producto producto){
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		ModelMap modelo = new ModelMap();
		String categoria = "MUJERES";
		modelo.put("servicioproducto", servicioproducto.verProductosPorCategoria(producto, categoria));	
		return new ModelAndView ("productosMu", modelo);
	}
	
	/*PRODUCTOS HOMBRES*/
	@RequestMapping ("/productosHo")
	public ModelAndView cargaProductosHombres(@ModelAttribute("producto")Producto producto){
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		ModelMap modelo = new ModelMap();
		String categoria = "HOMBRES";
		modelo.put("servicioproducto", servicioproducto.verProductosPorCategoria(producto, categoria));
		return new ModelAndView ("productosHo", modelo);
	}
	
	/*PRODUCTOS NIÑOS*/
	@RequestMapping ("/productosNi")
	public ModelAndView cargaProductosNinos(@ModelAttribute("producto")Producto producto){
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		ModelMap modelo = new ModelMap();
		String categoria = "NIÑOS";
		modelo.put("servicioproducto", servicioproducto.verProductosPorCategoria(producto, categoria));	
		return new ModelAndView ("productosNi", modelo);
	}
	
	/*PRODUCTO DETALLE*/
	@RequestMapping (value = "/productoDetalle")
	public ModelAndView home(@ModelAttribute("producto")Producto producto,
							 @RequestParam(value="id")Integer id){
		//ColeccionProducto servicioproducto = ColeccionProducto.getInstance();
		String disponible = null;
		//Stock stock = Stock.getInstance();
		ModelMap modelo = new ModelMap();
		try{
			serviciostock.buscaProductoEnStock(producto);
			if(serviciostock.obtenerCantidad(producto)!=0){
				disponible = "En Stock";
			}else{
				disponible = "No disponible";
			}
		} catch (Exception e) {
			disponible = "No disponible";
			try {			
				modelo.put("servicioproducto", servicioproducto.buscaProducto(producto));
			} catch (Exception e1) {
			}
		}
		try {			
			modelo.put("servicioproducto", servicioproducto.buscaProducto(producto));
		} catch (Exception e) {
		}
		modelo.put("disponible", disponible);
		return new ModelAndView ("productoDetalle", modelo);
	}
	
	/*BUSCADOR*/
	@RequestMapping(value="/resultadoBusqueda", method = RequestMethod.POST)
	public ModelAndView resultadoBusqueda(@ModelAttribute("buscar")Producto producto, HttpServletRequest request){
		ModelMap modelo = new ModelMap();
		//ColeccionProducto servicioProducto = ColeccionProducto.getInstance();
		String info;
		String busqueda = request.getParameter("busqueda");
		modelo.put("busqueda", busqueda);
		try{
			servicioproducto.buscarProductoBuscador(busqueda);
			servicioproducto.verProductos();
			modelo.put("servicioProducto", servicioproducto.verResultadoBusqueda(producto, busqueda));
			
			info = "RESULTADOS DE LA BUSQUEDA";
			}
			catch(Exception e){
				info= e.getMessage();
			    modelo.put("info",info);
			}
		modelo.put("busqueda", busqueda);
		modelo.put("info", info);
	
		return new ModelAndView("/resultadoBusqueda", modelo);
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
