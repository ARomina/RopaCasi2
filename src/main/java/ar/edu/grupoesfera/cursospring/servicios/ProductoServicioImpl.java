package ar.edu.grupoesfera.cursospring.servicios;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.grupoesfera.cursospring.modelo.Producto;

@Service("servicioproducto")
@MultipartConfig
public class ProductoServicioImpl implements ProductoServicio {

	private Set<Producto> productos = new TreeSet<Producto>();
	
	@Override
	/*BUSCAR PRODUCTO*/
	public Boolean buscaProducto(Producto producto) throws Exception{
	      for(Iterator<Producto> it = productos.iterator(); it.hasNext();){
	    	  Producto cada = it.next();
	    		if(producto.getId().equals(cada.getId())){
	    			producto.setId(cada.getId());
		    	    producto.setCategoria(cada.getCategoria());
		    	    producto.setNombreProducto(cada.getNombreProducto());
		    	    producto.setDescripcion(cada.getDescripcion());
		    	    producto.setImagenproducto(cada.getImagenproducto());
		    	    producto.setNombreimagen(cada.getNombreimagen());
		    	    producto.setColor(cada.getColor());
		    	    producto.setTalle(cada.getTalle());
		    	    producto.setPrecio(cada.getPrecio());
		    	    producto.setNovedad(cada.getNovedad());
	    			return true;
	    		}
	      }
	      			producto.getId();
	    			throw new Exception ("EL PRODUCTO NO EXISTE");
	}
	
	@Override
	/*GUARDAR PRODUCTO EXISTENTE*/
	public void guardaProductoExistente(Producto producto){
	      for(Iterator<Producto> it = productos.iterator(); it.hasNext();){
	    	  Producto cada = it.next();
	    		if(producto.getId().equals(cada.getId())){
	    			producto.setId(cada.getId());
	    			producto.setCategoria(cada.getCategoria());
	    			producto.setNombreProducto(cada.getNombreProducto());
		    	    producto.setDescripcion(cada.getDescripcion());
	    			producto.setImagenproducto(cada.getImagenproducto());
		    	    producto.setNombreimagen(cada.getNombreimagen());
	    			producto.setColor(cada.getColor());
	    			producto.setTalle(cada.getTalle());
	    			producto.setPrecio(cada.getPrecio());
	    			producto.setNovedad(cada.getNovedad());
	          }
	      }
	}
	
	@Override
	/*ALTA DE PRODUCTO*/
	public Boolean altaProducto(Producto producto)throws Exception{
  		if(this.productos.contains(producto)){
        	throw new Exception("EL CODIGO DE PRODUCTO YA EXISTE"); 
        }
        else{
        	
            Producto fichero= (Producto) producto;
            MultipartFile multipart = fichero.getImagenproducto();
            String ruta = "C:/PRODUCTOS/ropa/src/main/webapp/images/productos/";
            try {
                 File path = new File(ruta);
                 producto.setNombreimagen(multipart.getOriginalFilename());
                 multipart.transferTo(new File(path, multipart.getOriginalFilename()));
            } catch (Exception e) {
                // logger.error("Error al copiar fichero", e);
                 throw e;
            }
        }
        	this.productos.add(producto);  
        	return true;
        } 
	
	@Override
	/*LISTADO DE PRODUCTOS*/
	public Set<Producto> verProductos(){
		return this.productos;
	}
	
	@Override
	/*BAJA DE PRODUCTO*/
	public Boolean bajaProducto(Producto producto)throws Exception{
        if(this.productos.contains(producto)){
        	this.productos.remove(producto);
        	return true;
        }
        else{
        	throw new Exception("EL PRODUCTO NO EXISTE");      	
        }
    }

	@Override
	/*MODIFICACION DE PRODUCTO*/
	public void modificacionProducto(Producto producto){
            for(Iterator<Producto> it = productos.iterator(); it.hasNext();){
  	    	  Producto cada = it.next();
	    		if(cada.getId().equals(producto.getId())){
	    	    cada.getId();
            	cada.setCategoria(producto.getCategoria());
            	cada.setNombreProducto(producto.getNombreProducto());
            	cada.setDescripcion(producto.getDescripcion());
               	cada.getImagenproducto();
               	cada.getNombreimagen();
            	cada.setColor(producto.getColor());
            	cada.setTalle(producto.getTalle());
            	cada.setPrecio(producto.getPrecio());
            	cada.setNovedad(producto.getNovedad());
            }
          }
    }
	
	@Override
	/*LISTADO DE PRODUCTOS POR CATEGORIA*/
	public Set<Producto> verProductosPorCategoria(Producto producto, String categoria){
		 Set<Producto> listaPorCategoria = new TreeSet<Producto>();
         for (Producto cada : productos){  
        	 if(cada.getCategoria().toString().equals(categoria)){
        		 listaPorCategoria.add(cada);
        	 }
         }
         return listaPorCategoria;
	}
	
	@Override
	/*LISTADO DE NOVEDADES*/
	public Set<Producto> verProductosNovedades(Producto producto){
		 Set<Producto> novedades = new TreeSet<Producto>();
		 String esperado = "si";
         for (Producto cada : productos){  
        	 if(cada.getNovedad().equals(esperado)){
        		 novedades.add(cada);
        	 }
            }
         return novedades;
	}
	
	@Override
	/*BUSCADOR*/
	public Boolean buscarProductoBuscador(String busqueda) throws Exception{
	      for(Iterator<Producto> it = productos.iterator(); it.hasNext();){
	    	  Producto cada = it.next();
	    	  if(cada.getCategoria().toString().equals(busqueda) || busqueda.equals(cada.getNombreProducto()) || cada.getColor().toString().equals(busqueda) || cada.getTalle().toString().equals(busqueda)){
	    			return true;
	    		}
	      }
	    			throw new Exception ("NO SE OBTUVIERON RESULTADOS");
	}
	
	/*VER RESULTADOS DE BUSQUEDA*/
	public Set<Producto> verResultadoBusqueda(Producto producto, String busqueda){
		 Set<Producto> resultadoBusqueda = new TreeSet<Producto>();
        for (Producto cada : productos){  
        	if(cada.getCategoria().toString().equals(busqueda) || busqueda.equals(cada.getNombreProducto()) || cada.getColor().toString().equals(busqueda) || cada.getTalle().toString().equals(busqueda)){
       		 resultadoBusqueda.add(cada);
       	 }
        }
        return resultadoBusqueda;
	}

	//Getters y Setters
	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}


}
