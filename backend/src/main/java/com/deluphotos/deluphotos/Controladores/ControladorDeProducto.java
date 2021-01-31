package com.deluphotos.deluphotos.Controladores;

import com.deluphotos.deluphotos.Entidades.Producto;
import com.deluphotos.deluphotos.Repositorios.RepositorioDeProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(path="/api")
public class ControladorDeProducto {

    @Autowired
    private RepositorioDeProducto repositorioDeProducto;

    @GetMapping(path = "/saludar-a-maca")
    public String helloWorld(){
        return "Hola mona!";
    }

    @GetMapping("/")
    public String index() {
        return "¡Funciona!";
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
