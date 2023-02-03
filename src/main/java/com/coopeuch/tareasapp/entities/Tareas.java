package com.coopeuch.tareasapp.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "tareas_details")
public class Tareas {

	protected Tareas() {

	}

	@Id
	@GeneratedValue
	private Integer id;

	@JsonProperty("descripcion")
	@Column(nullable = false)
	private String descripcion;

	@JsonProperty("fechaCreacion")
	@Column(nullable = false)
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate fechaCreacion;

	@JsonProperty("vigente")
	@Column(nullable = false)
	private Boolean vigente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Boolean getVigente() {
		return vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
	}

	@Override
	public String toString() {
		return "Tareas [id=" + id + ", descripcion=" + descripcion + ", fechaCreacion=" + fechaCreacion + ", vigente="
				+ vigente + "]";
	}

	public Tareas(Integer id, String descripcion, LocalDate fechaCreacion, Boolean vigente) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.vigente = vigente;
	}

}
