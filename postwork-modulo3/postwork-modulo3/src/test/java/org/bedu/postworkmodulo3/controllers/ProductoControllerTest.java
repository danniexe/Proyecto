package org.bedu.postworkmodulo3.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bedu.postworkmodulo3.model.Cliente;
import org.bedu.postworkmodulo3.model.Producto;
import org.bedu.postworkmodulo3.services.ProductoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductoController.class)
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

        List<Producto> productos = Arrays.asList(
                Producto.builder().productoId(1L).nombre("Pepsi").categoria("Bebida").precio(15).build()

        );

        given(productoService.obtenProductos()).willReturn(productos);

        mockMvc.perform(get("/producto")
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].productoId", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Pepsi")))
                .andExpect(jsonPath("$[0].categoria", is("Bebida")))
                .andExpect(jsonPath("$[0].precio", is(15.00)));

    }

    @Test
    void creaProducto()throws Exception {
        Producto productoParametro = Producto.builder().nombre("Pepsi").categoria("Bebida").precio(15).build();
        Producto productoRespuesta = Producto.builder().productoId(1L).nombre("Pepsi").categoria("Bebida").precio(15).build();

        given(productoService.guardaProducto(productoParametro)).willReturn(productoRespuesta);

        mockMvc.perform(post("/producto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(productoParametro)))
                .andExpect(status().isCreated());

    }

    @Test
    void actualizaProducto() throws Exception{

        Producto productoParametro = Producto.builder().productoId(1L).nombre("Pepsi").categoria("Bebida").precio(15).build();
        mockMvc.perform(put("/producto/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(productoParametro)))
                .andExpect(status().isNoContent());
    }

    @Test
    void eliminaProducto() throws Exception{
        mockMvc.perform(delete("/producto/1")
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNoContent());
    }
}