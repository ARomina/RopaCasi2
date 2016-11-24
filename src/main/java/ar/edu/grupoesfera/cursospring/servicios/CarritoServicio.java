package ar.edu.grupoesfera.cursospring.servicios;

import java.util.Map;

import ar.edu.grupoesfera.cursospring.modelo.Producto;

public interface CarritoServicio {
	
	public void agregarProductosAlcarrito(Producto producto, Integer unidades);
	public Map<Producto, Integer> listadoDeCarrito();
	public Integer obtenerCantidadDeProductoEnCarrito(Producto producto);
	public void eliminarProductosDelCarrito(Producto producto, Integer cantidad);
	
	/*
	void agregarProductosAlCarrito();
	void eliminarProductosDelCarrito();
	Integer obtenerCantidadDeProductoEnCarrito();	
	Map<Producto, Integer>listadoDeCarrito();*/	
}
