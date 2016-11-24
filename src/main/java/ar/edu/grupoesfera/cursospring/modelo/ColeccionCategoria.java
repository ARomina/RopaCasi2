package ar.edu.grupoesfera.cursospring.modelo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ColeccionCategoria {


	private static ColeccionCategoria instance = new ColeccionCategoria();
	private List<Categoria> categorias = new LinkedList<Categoria>();
	private ColeccionCategoria(){}
	
	/*ALTA CATEGORIAS*/
	public void altaCategoria(Categoria categoria){
		this.categorias.add(categoria); 
	}
	
	/*LISTAR CATEGORIAS*/
	public List<Categoria> listaCategoria(){
	      for(Iterator<Categoria> it = categorias.iterator(); it.hasNext();){
	    	  Categoria cada = it.next();
	    		cada.getCategoria();	 
	      }
		  return this.categorias;
	}
	
	/*ELIMINAR CATEGORIA*/
	public List<Categoria> bajaCategoria(Categoria categoria){
		 this.categorias.remove(categoria);
		 return this.categorias;
	}
	
	/*GETTERS Y SETERS*/
	public static ColeccionCategoria getInstance() {
		return instance;
	}
	public static void setInstance(ColeccionCategoria instance) {
		ColeccionCategoria.instance = instance;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	/*EQUALS Y HASHCODE*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorias == null) ? 0 : categorias.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColeccionCategoria other = (ColeccionCategoria) obj;
		if (categorias == null) {
			if (other.categorias != null)
				return false;
		} else if (!categorias.equals(other.categorias))
			return false;
		return true;
	}

}
