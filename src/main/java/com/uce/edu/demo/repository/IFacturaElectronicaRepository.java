package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.FacturaElectronica;

public interface IFacturaElectronicaRepository {

	public void insertar(FacturaElectronica facturaElectronica);

	public void actualizar(FacturaElectronica facturaElectronica);

	public void eliminar(Integer id);

	public FacturaElectronica buscar(Integer id);

	public FacturaElectronica buscarNumero(String numero);
	
	

}
