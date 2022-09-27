package com.admin.productos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	@Column(name = "nombre", length = 60, nullable = false)
	private String nombre;
	
	@Column(name = "cantidad", length = 60, nullable = false)
	private Long cantidad;

	public Producto() {

	}

	public Producto(Long id, String nombre, Long cantidad) {
		super();
		this.user_id = user_id;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public Long getId() {
		return user_id;
	}

	public void setId(Long id) {
		this.user_id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

}
