package com.coopeuch.tareasapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coopeuch.tareasapp.entities.Tareas;



public interface TareasDataRepository extends JpaRepository<Tareas, Integer> {
	
	

}
