package com.deluphotos.deluphotos.Controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path="/api")
public class ControladorDePrueba {

    @GetMapping(path = "/saludar-a-maca")
    public String helloWorld(){
        return "Hola mona!";
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
