package ar.edu.grupoesfera.cursospring.servicios;

import java.util.Map;

import ar.edu.grupoesfera.cursospring.modelo.Producto;

public interface StockServicio {

	public Boolean buscaProductoEnStock(Producto producto)throws Exception;
	public Boolean agregarProducto(Producto producto)throws Exception;
	public Boolean eliminarProducto(Producto producto);
	public Map<Producto, Integer> obtenerStock();
	public Integer obtenerCantidad(Producto producto);
	public Boolean agregarStock(Producto producto, Integer cantidad);
	public Boolean revertirStock(Producto producto, Integer cantidad)throws Exception;
	public Boolean comprarProducto(Producto producto, Integer cantidad);
	
}
