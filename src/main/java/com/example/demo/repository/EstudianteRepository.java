package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteRepository {

	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);

	// se busca atravez de un identificador
	public Estudiante selecionar(String cedula);

	// se elimina atravez de un identificador
	public void eliminar(String cedula);

	// impresion de una lista
	public List<Estudiante> selecionarTodos();
}
