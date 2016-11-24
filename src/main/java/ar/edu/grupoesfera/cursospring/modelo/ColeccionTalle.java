package ar.edu.grupoesfera.cursospring.modelo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ColeccionTalle {


	private static ColeccionTalle instance = new ColeccionTalle();
	private List<Talle> talles = new LinkedList<Talle>();
	private ColeccionTalle(){}
	
	/*ALTA TALLES*/
	public void altaTalle(Talle talle){
		this.talles.add(talle); 
	}
	
	/*LISTAR TALLES*/
	public List<Talle> listaTalle(){
	      for(Iterator<Talle> it = talles.iterator(); it.hasNext();){
	    	  Talle cada = it.next();
	    		cada.getTalle();	 
	      }
		  return this.talles;
	}
	
	/*ELIMINAR COLOR*/
	public List<Talle> bajaTalle(Talle talle){
		 this.talles.remove(talle);
		 return this.talles;
	}
	
	/*GETTERS Y SETERS*/

	public static ColeccionTalle getInstance() {
		return instance;
	}

	public static void setInstance(ColeccionTalle instance) {
		ColeccionTalle.instance = instance;
	}

	public List<Talle> getTalles() {
		return talles;
	}

	public void setTalles(List<Talle> talles) {
		this.talles = talles;
	}

	/*EQUALS Y HASHCODE*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((talles == null) ? 0 : talles.hashCode());
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
		ColeccionTalle other = (ColeccionTalle) obj;
		if (talles == null) {
			if (other.talles != null)
				return false;
		} else if (!talles.equals(other.talles))
			return false;
		return true;
	}

}
