package ar.edu.grupoesfera.cursospring.modelo;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table (name = "Producto")
public class Producto implements Comparable<Producto>{ 

	/*ATRIBUTOS*/
	@Id
	@Column (name = "Id_Producto")
	private Integer id;
	@Column (name = "Nom_Producto")
	private String nombreProducto;
	@Column (name = "Desc_Producto")
	private String descripcion;
	
	@OneToOne
	@JoinColumn(name = "idColor")
	private Color color;
	
	@OneToOne
	@JoinColumn(name = "idTalle")
	private Talle talle;
	
	@Column (name = "Precio_Producto")
	private Float precio;
	
	@OneToOne
	@JoinColumn(name = "idCategoria")
	private Categoria categoria;
	
	@Lob
	@Column(name = "Img_Producto")
	private MultipartFile imagenproducto;

	@Column(name = "NombreIMG_Producto")
	private String nombreimagen;
	@Column (name = "Nov_Producto")
	private String novedad;
	
	public Producto(){}
	public Producto(Integer id, String nombreProducto, String descripcion, Color color, Talle talle, Float precio,
			Categoria categoria, MultipartFile imagenproducto, String nombreimagen, String novedad) {
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.color = color;
		this.talle = talle;
		this.precio = precio;
		this.categoria = categoria;
		this.imagenproducto = imagenproducto;
		this.nombreimagen = nombreimagen;
		this.novedad = novedad;
	}

	/*GETTERS Y SETTERS*/
	public Integer getId() {
		return id;
	}
	public Integer setId(Integer id) {
		return this.id = id;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Talle getTalle() {
		return talle;
	}
	public void setTalle(Talle talle) {
		this.talle = talle;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public MultipartFile getImagenproducto() {
		return imagenproducto;
	}
	public void setImagenproducto(MultipartFile imagenproducto) {
		this.imagenproducto = imagenproducto;
	}
	public String getNombreimagen() {
		return nombreimagen;
	}
	public void setNombreimagen(String nombreimagen) {
		this.nombreimagen = nombreimagen;
	}
	public String getNovedad() {
		return novedad;
	}
	public void setNovedad(String novedad) {
		this.novedad = novedad;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/*EQUALS Y HASHCODE*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Producto other = (Producto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	/*COMPARE TO*/
	@Override
	public int compareTo(Producto o) {
		return this.id.compareTo(o.id);
	}

}
