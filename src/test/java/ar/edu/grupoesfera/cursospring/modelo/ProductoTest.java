package ar.edu.grupoesfera.cursospring.modelo;

import java.io.FileInputStream;
import java.io.IOException;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class ProductoTest extends SpringTest{
		
		//Test creacion de producto correcto
		@SuppressWarnings("unused")
		@Test
		@Transactional
		@Rollback(true)
		
		public void TestProducto1() throws IOException{
			
			Producto producto1 = new Producto();
			producto1.setId(12);
			producto1.setNombreProducto("Remera");
			
			Categoria categoria1 = new Categoria("MUJERES");
			producto1.setCategoria(categoria1);
			
			producto1.setDescripcion("Remera manga corta de lycra");
			
			Color color1 = new Color("ROJO");
			producto1.setColor(color1);
			
			Talle talle1 = new Talle("M");
			producto1.setTalle(talle1);
			
			Producto archivo = producto1;
			//Actualizar con ruta a carpeta en desktop
			FileInputStream inputFile = new FileInputStream("C:/Users/Romina/Desktop/productos/h2.jpg");  
			//FileInputStream inputFile = new FileInputStream("C:/PRODUCTOS/ropa/src/main/webapp/images/productos/");
			MockMultipartFile file = new MockMultipartFile("h2", "h2", "multipart/form-data", inputFile); 
			file = (MockMultipartFile) archivo.getImagenproducto();
			archivo.setNombreimagen("h2.jpg");
			//file.transferTo(new File(file.getOriginalFilename()));
			
			producto1.setNovedad("si");
			producto1.setPrecio((float) 120.0);
			
		}
		
		//Test creacion producto incorrecto (Id incorrecto)
		@SuppressWarnings("unused")
		@Test
		@Transactional
		@Rollback(true)
		
		public void TestProducto2() throws IOException{
			
			Producto producto2 = new Producto();
			producto2.setId(99999999);
			producto2.setNombreProducto("Pantalón");
			
			Categoria categoria2 = new Categoria("HOMBRES");
			producto2.setCategoria(categoria2);
			
			producto2.setDescripcion("Pantalón de vestir");
			
			Color color2 = new Color("AZUL");
			producto2.setColor(color2);
			
			Talle talle2 = new Talle("42");
			producto2.setTalle(talle2);
			
			Producto archivo = producto2;
			//Actualizar con ruta a carpeta en desktop
			FileInputStream inputFile = new FileInputStream("C:/Users/Romina/Desktop/productos/h2.jpg");  
			//FileInputStream inputFile = new FileInputStream("C:/PRODUCTOS/ropa/src/main/webapp/images/productos/");
			MockMultipartFile file = new MockMultipartFile("h2", "h2", "multipart/form-data", inputFile); 
			file = (MockMultipartFile) archivo.getImagenproducto();
			archivo.setNombreimagen("h2.jpg");
			//file.transferTo(new File(file.getOriginalFilename()));
			
			producto2.setNovedad("si");
			producto2.setPrecio((float) 534.0);
			
			//assertTrue(producto2.getId()<9999);
			//assertFalse(producto2.getId()<9999);
			assertTrue(producto2.getId()>9999);
			
		}
		
}