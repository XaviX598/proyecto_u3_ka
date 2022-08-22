package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Factura;
@Repository
@Transactional
public class FacturadRepositoryImpl implements IFacturadRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public Factura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public int actualizarFecha(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		Query q = this.entityManager.createQuery("UPDATE Factura f SET f.fecha = :datoFecha");
		q.setParameter("datoFecha", fecha);
		return q.executeUpdate();
	}

	@Override
	public Factura buscarNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f WHERE f.numero>:numero", Factura.class);
		myQuery.setParameter("numero", numero);

		return myQuery.getSingleResult();
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f JOIN f.detalles d WHERE d.subtotal = :subtotal", Factura.class);
		myQuery.setParameter("subtotal", subtotal);

		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalles d ",
				Factura.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal subtotal) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE d.subtotal = :subtotal", Factura.class);
		myQuery.setParameter("subtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft() {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles d ",
				Factura.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(BigDecimal subtotal) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f RIGHT JOIN f.detalles d WHERE d.subtotal = :subtotal", Factura.class);
		myQuery.setParameter("subtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(BigDecimal subtotal) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura AND d.subtotal = :subtotal",
				Factura.class);
		myQuery.setParameter("subtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaFetchJoin(BigDecimal subtotal) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN FETCH f.detalles d WHERE d.subtotal = :subtotal", Factura.class);
		myQuery.setParameter("subtotal", subtotal);
		return myQuery.getResultList();
	}

}
