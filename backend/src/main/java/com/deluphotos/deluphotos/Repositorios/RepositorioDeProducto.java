package com.deluphotos.deluphotos.Repositorios;

import com.deluphotos.deluphotos.Entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDeProducto extends JpaRepository<Producto, Integer> {

}
