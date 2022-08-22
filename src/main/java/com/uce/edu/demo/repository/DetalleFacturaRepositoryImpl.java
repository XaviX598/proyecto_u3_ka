package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.DetalleFactura;

@Repository
@Transactional
public class DetalleFacturaRepositoryImpl implements IDetalleFacturaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalleFactura);
	}

	@Override
	public void actualizar(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(detalleFactura);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public DetalleFactura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(DetalleFactura.class, id);
	}

}
