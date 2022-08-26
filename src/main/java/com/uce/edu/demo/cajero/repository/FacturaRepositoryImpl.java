package com.uce.edu.demo.cajero.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Hotel;
//
//@Repository
//@Transactional
//public class FacturaRepositoryImpl implements IFacturaRepository {
//
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	@Override
//	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal) {
//		// TODO Auto-generated method stub
//		TypedQuery<Factura> myQuery = this.entityManager
//				.createQuery("SELECT f FROM Factura f JOIN f.detalles d WHERE d.subtotal = :subtotal", Factura.class);
//		myQuery.setParameter("subtotal", subtotal);
//
//		// para que traiga las habiatciones usando lazy en la clase y usamos size para
//		// garantizarnos que traiga las habitaciones SOLO EN EL REPOSITORY
//		List<Factura> facturas = myQuery.getResultList();
//		for (Factura f : facturas) {
//			f.getDetalles().size();
//		}
//		return myQuery.getResultList();
//	}
//
//	@Override
//	public List<Factura> buscarFacturaInnerJoin() {
//		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalles d ",
//				Factura.class);
//
//		return myQuery.getResultList();
//	}
//
//	@Override
//	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal subtotal) {
//		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
//				"SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE d.subtotal = :subtotal", Factura.class);
//		myQuery.setParameter("subtotal", subtotal);
//		return myQuery.getResultList();
//	}
//
//	@Override
//	public List<Factura> buscarFacturaOuterJoinLeft() {
//		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles d ",
//				Factura.class);
//
//		return myQuery.getResultList();
//	}
//
//	@Override
//	public List<Factura> buscarFacturaOuterJoinRight(BigDecimal subtotal) {
//		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
//				"SELECT f FROM Factura f RIGHT JOIN f.detalles d WHERE d.subtotal = :subtotal", Factura.class);
//		myQuery.setParameter("subtotal", subtotal);
//		return myQuery.getResultList();
//	}
//
//	@Override
//	public List<Factura> buscarFacturaJoinWhere(BigDecimal subtotal) {
//		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
//				"SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura AND d.subtotal = :subtotal",
//				Factura.class);
//		myQuery.setParameter("subtotal", subtotal);
//		return myQuery.getResultList();
//	}
//
//	@Override
//	public List<Factura> buscarFacturaFetchJoin(BigDecimal subtotal) {
//		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
//				"SELECT f FROM Factura f JOIN FETCH f.detalles d WHERE d.subtotal = :subtotal", Factura.class);
//		myQuery.setParameter("subtotal", subtotal);
//		return myQuery.getResultList();
//	}
//
//}
