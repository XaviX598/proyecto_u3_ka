package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.FacturaElectronica;
@Repository
@Transactional
public class FacturaElectronicaRepositoryImpl implements IFacturaElectronicaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(FacturaElectronica facturaElectronica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(facturaElectronica);
	}

	@Override
	public void actualizar(FacturaElectronica facturaElectronica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(facturaElectronica);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public FacturaElectronica buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(FacturaElectronica.class, id);
	}

	@Override
	public FacturaElectronica buscarNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<FacturaElectronica> myQuery = this.entityManager
				.createQuery("SELECT fe FROM FacturaElectronica fe WHERE fe.numero= :numero", FacturaElectronica.class);
		myQuery.setParameter("numero", numero);

		return myQuery.getSingleResult();
	}

}
