package com.coopeuch.tareasapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coopeuch.tareasapp.entities.Tareas;
import com.coopeuch.tareasapp.repository.TareasDataRepository;

@RestController
@RequestMapping("/v1/tareas/")
public class TareasController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TareasController.class);
	private TareasDataRepository repository;

	public TareasController(TareasDataRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/listarTareas")
	public List<Tareas> listarTareas() {

		LOGGER.info("Extrayendo datos");
		return repository.findAll();

	}

	@PostMapping("/agregarTarea")
	public ResponseEntity<Tareas> agregarTarea(@Valid @RequestBody Tareas tarea) {

		if (tarea.getDescripcion().isBlank()) {
			LOGGER.info("El campo descripcion no puede estar vacio");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} else if (tarea.getVigente() == null) {
			LOGGER.info("El campo vigente no puede estar vacio");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		Tareas saveTarea = repository.save(tarea);
		LOGGER.info("Tarea creada con id" + saveTarea.getId());
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping("/editarTarea/{id}")
	public ResponseEntity<Object> editarTarea(@PathVariable Integer id, @Valid @RequestBody Tareas tareaed) {
		if (tareaed.getDescripcion().isBlank()) {
			LOGGER.info("El campo descripcion no puede estar vacio");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} else if (tareaed.getVigente() == null) {
			LOGGER.info("El campo vigente no puede estar vacio");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		tareaed.setId(id);
		LOGGER.info("Tarea Modificada con identificador: " + id);
		repository.save(tareaed);
		return ResponseEntity.status(HttpStatus.OK).build();

	}

	@DeleteMapping("/removerTarea/{id}")
	public ResponseEntity<Object> removerTarea(@PathVariable int id) {
		if (repository.findById(id).isEmpty() == true) {
			LOGGER.info("El id no existe");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();

	}

}
