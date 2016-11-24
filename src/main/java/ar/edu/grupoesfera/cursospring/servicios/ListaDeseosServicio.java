package ar.edu.grupoesfera.cursospring.servicios;

import java.util.Set;

import ar.edu.grupoesfera.cursospring.modelo.Producto;

public interface ListaDeseosServicio {

	public Boolean buscarProductoLista(Producto producto);
	public Boolean guardaProductoLista(Producto producto);
	public Boolean ponerProductoLista(Producto producto);
	public Boolean quitarProductoLista(Producto producto);
	public Set<Producto> verProductosListaDeseos();
	public Boolean listaDeseosVacia();

}