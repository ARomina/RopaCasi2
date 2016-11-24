package ar.edu.grupoesfera.cursospring.modelo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ColeccionColor {


	private static ColeccionColor instance = new ColeccionColor();
	private List<Color> colores = new LinkedList<Color>();
	private ColeccionColor(){}
	
	/*ALTA COLORES*/
	public void altaColor(Color color){
		this.colores.add(color); 
	}
	
	/*LISTAR COLORES*/
	public List<Color> listaColor(){
	      for(Iterator<Color> it = colores.iterator(); it.hasNext();){
	    	  Color cada = it.next();
	    		cada.getColor();	 
	      }
		  return this.colores;
	}
	
	/*ELIMINAR COLOR*/
	public List<Color> bajaColor(Color color){
		 this.colores.remove(color);
		 return this.colores;
	}
	
	/*GETTERS Y SETERS*/

	public static ColeccionColor getInstance() {
		return instance;
	}

	public static void setInstance(ColeccionColor instance) {
		ColeccionColor.instance = instance;
	}

	public List<Color> getColores() {
		return colores;
	}

	public void setColores(List<Color> colores) {
		this.colores = colores;
	}

	/*EQUALS Y HASHCODE*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colores == null) ? 0 : colores.hashCode());
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
		ColeccionColor other = (ColeccionColor) obj;
		if (colores == null) {
			if (other.colores != null)
				return false;
		} else if (!colores.equals(other.colores))
			return false;
		return true;
	}
}
