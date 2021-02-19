package com.deluphotos.deluphotos.Integracion.Controladores;

import com.deluphotos.deluphotos.Controladores.ControladorDeProducto;
import com.deluphotos.deluphotos.Entidades.Producto;
import com.deluphotos.deluphotos.Repositorios.RepositorioDeProducto;
import com.deluphotos.deluphotos.Servicios.ServicioDeProducto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void seObtieneEstado200CuandoSePidenTodosLosProductos() throws Exception {
        List<Producto> productos = new LinkedList<>();
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

        Mockito.when(mockServicioDeProducto.obtenerTodosLosProductos()).thenReturn(productos);
        MvcResult mvcResult = mvc.perform(get("/api/obtenerProductos")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String respuestaDelControlador = mvcResult.getResponse().getContentAsString();

        assertThat(respuestaDelControlador).contains("Tazas re copadas");
        assertThat(respuestaDelControlador).contains("Las mejores polaroid");
        verify(mockServicioDeProducto, times(1)).obtenerTodosLosProductos();
    }

}
