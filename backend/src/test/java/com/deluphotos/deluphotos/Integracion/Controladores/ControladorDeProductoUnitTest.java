package com.deluphotos.deluphotos.Integracion.Controladores;

import com.deluphotos.deluphotos.Controladores.ControladorDeProducto;
import com.deluphotos.deluphotos.Entidades.Producto;
import com.deluphotos.deluphotos.Repositorios.RepositorioDeProducto;
import com.deluphotos.deluphotos.Servicios.ServicioDeProducto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ControladorDeProducto.class)
public class ControladorDeProductoUnitTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RepositorioDeProducto repositorioDeProducto;

    @MockBean
    private ServicioDeProducto mockServicioDeProducto;

    @Test
    public void seObtieneEstado200CuandoSePidenTodosLosProductos() throws Exception {
        /*List<Producto> productos = new LinkedList<>();
        Producto producto1 = new Producto();
        producto1.setNombre("Tazas");
        producto1.setPrecio(190L);
        producto1.setDescripción("Tazas re copadas");

        Producto producto2 = new Producto();
        producto2.setNombre("Polariod");
        producto2.setPrecio(50L);
        producto2.setDescripción("Las mejores polaroid");

        productos.add(producto1);
        productos.add(producto2);
        */
        mvc.perform(get("/api/obtenerProductos")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

}
