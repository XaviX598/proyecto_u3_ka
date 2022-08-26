package com.uce.edu.demo.tarea31.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea31.repository.IClienteRepository;
import com.uce.edu.demo.tarea31.repository.modelo.Cliente;



@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClienteRepository iClienteRepository;

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Override
	@Transactional(value=TxType.REQUIRED)
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepository.insertar(cliente);
	}

	@Override
	public Cliente buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepository.buscar(cedula);
	}

}
