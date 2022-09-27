package com.admin.productos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.productos.modelo.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long>{
	

}
