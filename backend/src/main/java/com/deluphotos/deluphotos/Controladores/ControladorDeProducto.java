package com.deluphotos.deluphotos.Controladores;

import com.deluphotos.deluphotos.Entidades.Producto;
import com.deluphotos.deluphotos.Repositorios.RepositorioDeProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public @ResponseBody ResponseEntity agregarProducto(@RequestParam String nombre, @RequestParam Long precio, @RequestParam String descripción){
        ResponseEntity respuesta = null;
        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre(nombre);
        nuevoProducto.setPrecio(precio);
        nuevoProducto.setDescripción(descripción);

        repositorioDeProducto.save(nuevoProducto);

        return respuesta.ok().body("Nuevo producto agregado");
    }

    @GetMapping("/obtenerProductos")
    public @ResponseBody ResponseEntity obtenerTodosLosProductos(){
        ResponseEntity respuesta = null;
        List<Producto> resultado = repositorioDeProducto.findAll();

        return respuesta.ok().body(resultado);
    }

}
