package com.coopeuch.tareasapp.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.coopeuch.tareasapp.entities.Tareas;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
class TareasControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void contextLoads() {
	}

	@Test
	public void testlistarTareas() throws Exception {
		RequestBuilder requestListar = MockMvcRequestBuilders.get("/v1/tareas/listarTareas");
		mvc.perform(requestListar).andExpect(status().isOk());
	}

	@Test
	public void testagregarTarea() throws Exception {
		Tareas guardatarea = new Tareas(1, "Tarea de prueba", LocalDate.now(), true);
		RequestBuilder requestGuardar = MockMvcRequestBuilders.post("/v1/tareas/agregarTarea")
				.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(guardatarea));
		mvc.perform(requestGuardar).andExpect(status().isOk());
	}

	@Test
	public void testeditarTarea() throws Exception {
		Tareas guardatarea = new Tareas(1, "Tarea de prueba", LocalDate.now(), true);
		RequestBuilder requestGuardar = MockMvcRequestBuilders.post("/v1/tareas/agregarTarea")
				.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(guardatarea));
		mvc.perform(requestGuardar).andExpect(status().isOk());

		Tareas editartarea = new Tareas(1, "Tarea de prueba nueva", LocalDate.now(), true);
		RequestBuilder requestEditar = MockMvcRequestBuilders.put("/v1/tareas/editarTarea/1")
				.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(editartarea));
		mvc.perform(requestEditar).andExpect(status().isOk());
	}

	@Test
	public void testremoverTarea() throws Exception {
		RequestBuilder requestBorrar = MockMvcRequestBuilders.delete("/v1/tareas/removerTarea/1");
		mvc.perform(requestBorrar).andExpect(status().isOk());
	}

}
