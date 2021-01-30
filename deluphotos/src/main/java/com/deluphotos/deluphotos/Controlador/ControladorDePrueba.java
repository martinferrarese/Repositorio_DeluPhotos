package com.deluphotos.deluphotos.Controlador;

import com.deluphotos.deluphotos.Entidad.Producto;
import com.deluphotos.deluphotos.Repositorio.RepositorioDeProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RestController()
@RequestMapping(path="/api")
public class ControladorDePrueba {

    @Autowired
    private RepositorioDeProducto repositorioDeProducto;

    @GetMapping(path = "/saludar-a-maca")
    public String helloWorld(){
        return "Hola mona!";
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/agregarProducto")
    public @ResponseBody String agregarProducto(@RequestParam String nombre, @RequestParam Long precio, @RequestParam String descripción){
        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre(nombre);
        nuevoProducto.setPrecio(precio);
        nuevoProducto.setDescripción(descripción);

        repositorioDeProducto.save(nuevoProducto);

        return String.format("Se agregó el nuevo producto con nombre: {0}, precio: {1} y descripción: {2}", nombre, precio.toString(), descripción);
    }

    @GetMapping("/obtenerProductos")
    public @ResponseBody Iterable<Producto> obtenerTodosLosProductos(){
        return repositorioDeProducto.findAll();
    }

}
