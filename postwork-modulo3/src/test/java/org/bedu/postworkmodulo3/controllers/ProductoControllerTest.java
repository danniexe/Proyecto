package org.bedu.postworkmodulo3.controllers;

import org.bedu.postworkmodulo3.model.Etapa;
import org.bedu.postworkmodulo3.model.Producto;
import org.bedu.postworkmodulo3.services.EtapaService;
import org.bedu.postworkmodulo3.services.ProductoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EtapaController.class)
class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService productoService;

    @Test
    void getProducto() throws Exception{

        given(productoService.obtenProducto(anyLong())).willReturn(Optional.of(Producto.builder().productoId(1L).nombre("Soda").categoria("Bebida").build()));

        mockMvc.perform(get("/producto/1")
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productoId", is(1)))
                .andExpect(jsonPath("$.nombre", is("Soda")))
                .andExpect(jsonPath("$.categoria", is("Bebida")));

    }

    @Test
    void getProductos() throws Exception{
    }

    @Test
    void creaProducto()throws Exception {
    }

    @Test
    void actualizaProducto() throws Exception{
    }

    @Test
    void eliminaProducto() throws Exception{
    }
}