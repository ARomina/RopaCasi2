package ar.edu.grupoesfera.cursospring.servicios;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import ar.edu.grupoesfera.cursospring.modelo.Producto;

@Service("servicioListaDeseos")
public class ListaDeseosServicioImpl implements ListaDeseosServicio{
	
	private Set<Producto> productosListaDeseos = new TreeSet<Producto>();
	
	//Buscador
	public Boolean buscarProductoLista(Producto producto){
		if(this.productosListaDeseos.contains(producto)){
		  
		   return true;
		}
		
		 producto.getId();
		 return false;
	}
	
	//Guardar
	public Boolean guardaProductoLista(Producto producto){
	      for(Iterator<Producto> it = productosListaDeseos.iterator(); it.hasNext();){
	    	  Producto cada = it.next();
	    		if(producto.getId().equals(cada.getId())){
	    			producto.setId(cada.getId());
	    			producto.setCategoria(cada.getCategoria());
	    			producto.setNombreProducto(cada.getNombreProducto());
	    			producto.setImagenproducto(cada.getImagenproducto());
		    	    producto.setNombreimagen(cada.getNombreimagen());
	    			producto.setColor(cada.getColor());
	    			producto.setTalle(cada.getTalle());
	    			producto.setPrecio(cada.getPrecio());
	    			return true;
	          }
	      }
	      return false;
	}
	
	//Poner el producto indicado en lista de deseos
	public Boolean ponerProductoLista(Producto producto){
  		if(!this.productosListaDeseos.contains(producto)){
  			this.productosListaDeseos.add(producto);
  			return true;  //si ya esta, no hace nada
        }
        else{
        	//this.productosListaDeseos.add(producto);  
        	return true;  //si no está, lo agrega
        } 
	}
	
	//Quitar un determinado producto de la lista de deseos
	public Boolean quitarProductoLista(Producto producto){
  		if(this.productosListaDeseos.contains(producto)){
  			this.productosListaDeseos.remove(producto);
  			return true;  //si ya esta, borra el producto de la lista
        }
        else{
        	return false;  //si no está, no hace nada
        } 
	}
	
	//Ver productos en la lista
	public Set<Producto> verProductosListaDeseos(){
		return this.productosListaDeseos;
	}
	
	//Comprueba lista vacia
	public Boolean listaDeseosVacia(){
		if(this.productosListaDeseos.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}

	//Getters y Setters
	public Set<Producto> getProductosListaDeseos() {
		return productosListaDeseos;
	}

	public void setProductosListaDeseos(Set<Producto> productosListaDeseos) {
		this.productosListaDeseos = productosListaDeseos;
	}

}