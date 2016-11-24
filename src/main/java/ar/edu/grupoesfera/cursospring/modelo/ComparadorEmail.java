package ar.edu.grupoesfera.cursospring.modelo;

import java.util.Comparator;

public class ComparadorEmail implements Comparator<Usuario>{

	@Override
	public int compare(Usuario o1, Usuario o2) {
		return o1.geteMail().compareTo(o2.geteMail());
	}
}
