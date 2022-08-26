package com.uce.edu.demo.tarea31.service;

import com.uce.edu.demo.tarea31.repository.modelo.Cliente;

public interface IClienteService {

	public void insertar(Cliente cliente);

	public Cliente buscar(String cedula);

}
