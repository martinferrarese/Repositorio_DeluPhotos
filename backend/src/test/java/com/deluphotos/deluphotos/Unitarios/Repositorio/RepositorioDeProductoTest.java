package com.deluphotos.deluphotos.Unitarios.Repositorio;

import com.deluphotos.deluphotos.Entidades.Producto;
import com.deluphotos.deluphotos.Repositorios.RepositorioDeProducto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositorioDeProductoTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private RepositorioDeProducto repositorioDeProducto;

    private List<Producto> resultado;
    private Producto producto1;
    private Producto producto2;
    private Producto producto3;

    @Test
    public void seObtienenLosProductosTresYaCargadosEnLaBaseDeDatos(){
        dadoQueExistenTresProductosCargadosEnLaBaseDeDatos();
        cuandoObtengoTodosLosProductos();
        entoncesObtengoLosTresProductos();
    }

    private void dadoQueExistenTresProductosCargadosEnLaBaseDeDatos() {
        producto1 = new Producto();
        producto1.setNombre("Tazas");
        producto1.setPrecio(190L);
        producto1.setDescripción("Tazas re copadas");
        testEntityManager.persist(producto1);

        producto2 = new Producto();
        producto2.setNombre("Polariod");
        producto2.setPrecio(50L);
        producto2.setDescripción("Las mejores polaroid");
        testEntityManager.persist(producto2);

        producto3 = new Producto();
        producto3.setNombre("Remera");
        producto3.setPrecio(870L);
        producto3.setDescripción("Remera de lo maś cheta");
        testEntityManager.persist(producto3);
    }

    private void cuandoObtengoTodosLosProductos() {
        resultado = repositorioDeProducto.findAll();
    }

    private void entoncesObtengoLosTresProductos() {
        assertThat(resultado.size()).isEqualTo(3);
        assertThat(resultado.get(0).getNombre()).isEqualTo(producto1.getNombre());
        assertThat(resultado.get(1).getDescripción()).isEqualTo(producto2.getDescripción());
        assertThat(resultado.get(2).getPrecio()).isEqualTo(producto3.getPrecio());
    }
}
