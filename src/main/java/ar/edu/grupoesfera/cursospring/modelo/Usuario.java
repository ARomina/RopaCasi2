package ar.edu.grupoesfera.cursospring.modelo;

public class Usuario implements Comparable<Usuario>{

	private String nombreYapellido;
	private Integer dni;
	private String domicilio;
	private Integer telefono;
	private String fechaNacimiento;
	private String eMail;
	private String clave;
	private String clave2;
	private String tipo = "Usuario";
	
	public Usuario() {}


	/*GETTERS Y SETTERS*/
	public String getNombreYapellido() {
		return nombreYapellido;
	}
	public void setNombreYapellido(String nombreYapellido) {
		this.nombreYapellido = nombreYapellido;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getClave2() {
		return clave2;
	}

	public void setClave2(String clave2) {
		this.clave2 = clave2;
	}


	/*EQUALS Y HASHCODE*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
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
		Usuario other = (Usuario) obj;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		return true;
	}

	/*COMPARE TO*/
	@Override
	public int compareTo(Usuario o) {
		return this.eMail.compareTo(o.eMail);
	}

	//toString
	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", eMail="
				+ eMail + ", clave=" + clave + ", clave2=" + clave2 + "]";
	}

}
