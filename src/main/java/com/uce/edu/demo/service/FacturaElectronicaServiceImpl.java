package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;

@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService
{

	@Autowired
	private IFacturaElectronicaRepository iFacturaElectronicaRepository;
	@Override
	public void insertar(FacturaElectronica facturaElectronica) {
		// TODO Auto-generated method stub
		this.iFacturaElectronicaRepository.insertar(facturaElectronica);
	}

	@Override
	public void actualizar(FacturaElectronica facturaElectronica) {
		// TODO Auto-generated method stub
		this.iFacturaElectronicaRepository.actualizar(facturaElectronica);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iFacturaElectronicaRepository.eliminar(id);
	}

	@Override
	public FacturaElectronica buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iFacturaElectronicaRepository.buscar(id);
	}

	@Override
	public FacturaElectronica buscarNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iFacturaElectronicaRepository.buscarNumero(numero);
	}

}
