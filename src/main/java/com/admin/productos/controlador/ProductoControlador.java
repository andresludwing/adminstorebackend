package com.admin.productos.controlador;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.productos.excepciones.ResourceNotFoundException;
import com.admin.productos.modelo.Producto;
import com.admin.productos.repositorio.ProductoRepositorio;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoControlador {

	@Autowired
	private ProductoRepositorio repositorio;
// Metodo listar todos los Productos
	@GetMapping("/productos")
	public List<Producto> listarTodosProductos() {
		return repositorio.findAll();
		
	}
	
//Metodo para guardar Producto	
	@PostMapping("/productos")
	public Producto guardaProducto(@RequestBody Producto producto) {
		return repositorio.save(producto);
	}
// Metodo para buscar un Producto por id	
	@GetMapping("/productos/{user_id}")
	public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long user_id){
		Producto producto = repositorio.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("No Existe Producto con el id :" + user_id));
							return ResponseEntity.ok(producto);
	}
	
// metodo para actualizar Producto	
	@PutMapping("/productos/{user_id}")
	public ResponseEntity<Producto> actualizarProducto(@PathVariable Long user_id, @RequestBody Producto detalleProducto){
		Producto producto = repositorio.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("No Existe Producto con el id :" + user_id));
							
		producto.setNombre(detalleProducto.getNombre());
		producto.setCantidad(detalleProducto.getCantidad());
		
		Producto productoActualizado = repositorio.save(producto);
		return ResponseEntity.ok(productoActualizado);
	}

}
