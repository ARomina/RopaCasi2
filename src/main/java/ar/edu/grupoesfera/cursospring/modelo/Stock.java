package ar.edu.grupoesfera.cursospring.modelo;

import java.util.HashMap;
import java.util.Map;

public class Stock {
	private static Stock instance = new Stock();
	private Map<Producto, Integer> stock = new HashMap<Producto, Integer>();
	
	private Stock(){
	}

//	/*BUSCA PRODUCTO EN EL STOCK*/
//	public Boolean buscaProductoEnStock(Producto producto)throws Exception{
//		if(this.stock.containsKey(producto)){
//			this.stock.containsKey(producto);
//			return true;
//		}
//		throw new Exception("EL PRODUCTO NO EXISTE EN EL STOCK"); 
//	}
//	
//	/*ALTA DE PRODUCTO EN EL STOCK*/
//	public Boolean agregarProducto(Producto producto)throws Exception{
//		if(this.stock.containsKey(producto)){
//			throw new Exception("EL PRODUCTO YA TIENE STOCK"); 
//		}
//		this.stock.put(producto, 0);
//		return true;
//	}
//	
//	/*BAJA DE PRODUCTO EN STOCK*/
//	public Boolean eliminarProducto(Producto producto){
//		if(!this.stock.containsKey(producto)){
//			return false;
//		}
//		this.stock.remove(producto);
//		return true;
//	}
//	
//	/*LISTADO DE STOCK*/
//	public Map<Producto, Integer> obtenerStock(){
//		return stock;
//	}
//	
//	/*MUESTRA CANTIDAD DEL PRODUCTO*/
//	public Integer obtenerCantidad(Producto producto){
//		if(!this.stock.containsKey(producto)){
//			return null;
//		}
//		return this.stock.get(producto);
//	}
//	
//	/*ALTA DE STOCK A PRODUCTO*/
//	public Boolean agregarStock(Producto producto, Integer cantidad){
//		if(!this.stock.containsKey(producto)){
//			return false;
//		}
//		Integer nuevaCantidad = this.stock.get(producto) + cantidad;
//		this.stock.put(producto, nuevaCantidad);
//		return true;
//	}
//	
//	
//	/*REVIERTE ALTA DE STOCK A PRODUCTO */
//	public Boolean revertirStock(Producto producto, Integer cantidad)throws Exception{
//		if(!this.stock.containsKey(producto)){
//			return false;
//		}
//		if(cantidad > this.stock.get(producto)){
//			throw new Exception("EL STOCK NO PUEDE SER NEGATIVO");
//		}
//		Integer nuevaCantidad = this.stock.get(producto) - cantidad;
//		this.stock.put(producto, nuevaCantidad);
//		return true;
//	}
//	
//	/*CARRITO*/
//	public Boolean comprarProducto(Producto producto, Integer cantidad){
//		if(!this.stock.containsKey(producto)){
//			return false;
//		}
//		Integer nuevaCantidad = this.stock.get(producto) - cantidad;
//		this.stock.put(producto, nuevaCantidad);
//		return true;
//	}
	
	/*GETTERS Y SETTERS*/
	public static Stock getInstance() {
		return instance;
	}

	public static void setInstance(Stock instance) {
		Stock.instance = instance;
	}

	public Map<Producto, Integer> getStock() {
		return stock;
	}

	public void setStock(Map<Producto, Integer> stock) {
		this.stock = stock;
	}

}

