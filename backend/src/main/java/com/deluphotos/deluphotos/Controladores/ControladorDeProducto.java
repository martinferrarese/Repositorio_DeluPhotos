package com.deluphotos.deluphotos.Controladores;

import com.deluphotos.deluphotos.Entidades.Producto;
import com.deluphotos.deluphotos.Repositorios.RepositorioDeProducto;
import com.deluphotos.deluphotos.Servicios.ServicioDeProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path="/api")
public class ControladorDeProducto {

    @Autowired
    private ServicioDeProducto servicioDeProducto;

    @GetMapping(path = "/saludar-a-maca")
    public String helloWorld(){
        return "Hola mona!";
    }

    @GetMapping("/")
    public String index() {
        return "¡Funciona!";
    }

    @PostMapping("/agregarProducto")
    public @ResponseBody ResponseEntity agregarProducto(@RequestBody Producto nuevoProducto){
        ResponseEntity respuesta = null;
        servicioDeProducto.agregarProducto(nuevoProducto);

        return respuesta.ok().body("Nuevo producto agregado. Nombre: " + nuevoProducto.getNombre());
    }

    @GetMapping("/obtenerProductos")
    public @ResponseBody ResponseEntity obtenerTodosLosProductos(){
        ResponseEntity respuesta = null;
        List<Producto> resultado = servicioDeProducto.obtenerTodosLosProductos();

        return respuesta.ok().body(resultado);
    }

}
