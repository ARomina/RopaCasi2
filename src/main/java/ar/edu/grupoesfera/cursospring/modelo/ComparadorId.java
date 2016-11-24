package ar.edu.grupoesfera.cursospring.modelo;

import java.util.Comparator;

public class ComparadorId implements Comparator<Producto>{

	@Override
	public int compare(Producto o1, Producto o2) {
		return o1.getId().compareTo(o2.getId());
	}
}
