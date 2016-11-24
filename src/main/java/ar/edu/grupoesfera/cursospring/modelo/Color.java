package ar.edu.grupoesfera.cursospring.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Color")
public class Color {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "Id_Color")
	private Integer idColor;
	
	@Column (name = "Color")
	private String color;
	
	public Color(String color) {
		this.color=color;
	}	


	/*GETTERS Y SETTERS*/

	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

	/*EQUALS Y HASHCODE*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
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
		Color other = (Color) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}


	/*SOBREESCRITURA DE METODO TOSTRING*/
	@Override
	public String toString() {
		color.toString();
		return color;
	}
}
