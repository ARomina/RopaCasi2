package ar.edu.grupoesfera.cursospring.servicios;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import ar.edu.grupoesfera.cursospring.modelo.Producto;

@Service("serviciocarrito")
public class CarritoServicioImpl implements CarritoServicio{

	private Map<Producto, Integer> carrito = new HashMap<Producto, Integer>();
	
	/*AGREGAR PRODUCTOS AL CARRITO*/
	public void agregarProductosAlcarrito(Producto producto, Integer unidades){
		if(this.carrito.containsKey(producto)){
			this.carrito.containsKey(producto);
			Integer nuevasUnidades= this.carrito.get(producto) + unidades;
			this.carrito.put(producto, nuevasUnidades);
		}else{
			this.carrito.put(producto, unidades);
		}
	}
	
	/*LISTADO DE CARRITO*/
	public Map<Producto, Integer> listadoDeCarrito(){
		return carrito;
	}
	
	/*MUESTRA CANTIDAD DEL PRODUCTO EN EL CARRITO*/
	public Integer obtenerCantidadDeProductoEnCarrito(Producto producto){
		if(!this.carrito.containsKey(producto)){
			return null;
		}
		return this.carrito.get(producto);
	}

	/*ELIMINAR DE PRODUCTO DEL CARRITO*/
	public void eliminarProductosDelCarrito(Producto producto, Integer cantidad){
		if(!this.carrito.containsKey(producto)){
		}
		Integer nuevaCantidad = this.carrito.get(producto) - cantidad;
		this.carrito.put(producto, nuevaCantidad);
		if(nuevaCantidad == 0){
		this.carrito.remove(producto);			
		}
	}

	//Getters y Setters
	public Map<Producto, Integer> getCarrito() {
		return carrito;
	}

	public void setCarrito(Map<Producto, Integer> carrito) {
		this.carrito = carrito;
	}
	
}
