package ar.edu.grupoesfera.cursospring.modelo;

public class EstadoPedido {
	
	private String estadoPedido;

	public EstadoPedido(){}
	
	public EstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	//Getters y Setters	
	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	//HashCode / Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estadoPedido == null) ? 0 : estadoPedido.hashCode());
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
		EstadoPedido other = (EstadoPedido) obj;
		if (estadoPedido == null) {
			if (other.estadoPedido != null)
				return false;
		} else if (!estadoPedido.equals(other.estadoPedido))
			return false;
		return true;
	}

}
