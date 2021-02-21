package com.deluphotos.deluphotos.Servicios;

import com.deluphotos.deluphotos.Entidades.Producto;
import com.deluphotos.deluphotos.Repositorios.RepositorioDeProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioDeProducto {

    @Autowired
    private RepositorioDeProducto repositorioDeProducto;

    public List<Producto> obtenerTodosLosProductos() {
        return repositorioDeProducto.findAll();
    }

    public Producto agregarProducto(Producto nuevoProducto) {
        return repositorioDeProducto.save(nuevoProducto);
    }
}
