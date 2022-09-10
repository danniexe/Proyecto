package org.bedu.postworkmodulo3.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bedu.postworkmodulo3.model.Cliente;
import org.bedu.postworkmodulo3.model.Etapa;
import org.bedu.postworkmodulo3.services.EtapaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest(EtapaController.class)
class EtapaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EtapaService etapaService;

    @Test
    void getEtapa() throws Exception{
        given(etapaService.obtenEtapa(anyLong())).willReturn(Optional.of(Etapa.builder().etapaId(1L).nombre("Nombre").orden(1).build()));

        mockMvc.perform(get("/etapa/1")
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.etapaId", is(1)))
                .andExpect(jsonPath("$.nombre", is("Nombre")))
                .andExpect(jsonPath("$.orden", is(1)));

    }

    @Test
    void getEtapas() throws Exception {

        List<Etapa> etapas = Arrays.asList(
                Etapa.builder().etapaId(1L).nombre("Nombre 1").orden(1).build(),
                Etapa.builder().etapaId(2L).nombre("Nombre 1").orden(2).build()
        );

        given(etapaService.obtenEtapas()).willReturn(etapas);

        mockMvc.perform(get("/etapa")
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].etapaId", is(1)));
    }

    @Test
    void creaEtapa() throws Exception{

        Etapa etapaParametro = Etapa.builder().etapaId(1L).nombre("Nombre 1").orden(1).build();
        Etapa etapaRespuesta = Etapa.builder().etapaId(2L).nombre("Nombre 2").orden(2).build();

        given(etapaService.guardaEtapa(etapaParametro)).willReturn(etapaRespuesta);

        mockMvc.perform(post("/etapa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(etapaParametro)))
                .andExpect(status().isCreated());

    }

    @Test
    void actualizaEtapa() throws Exception{

        Etapa etapaParametro = Etapa.builder().etapaId(1L).nombre("Nombre 1").orden(1).build();

        mockMvc.perform(put("/etapa/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(etapaParametro)))
                .andExpect(status().isNoContent());

    }

    @Test
    void eliminaEtapa() throws Exception{
        mockMvc.perform(delete("/etapa/1")
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNoContent());
    }
}