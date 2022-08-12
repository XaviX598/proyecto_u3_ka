package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {
	@PersistenceContext
	private EntityManager entityManager;

	private static final Logger log = Logger.getRootLogger();

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		// SE PUEDE PONER INNER JOIN O SOLO JOIN
		// la plabara habitaciones es el nombre de la referencia que dimos en Hotel
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo = :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);

		// para que traiga las habiatciones usando lazy en la clase y usamos size para
		// garantizarnos que traiga las habitaciones SOLO EN EL REPOSITORY
		List<Hotel> hoteles = myQuery.getResultList();
		for (Hotel h : hoteles) {
			h.getHabitaciones().size();
		}

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha ",
				Hotel.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo = :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha",
				Hotel.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo = :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		// SELECT * FROM hotel ho, habiotacion ha where ho.hote_id = ha.habi_id_hotel
		// and ha.habi_tipo = 'Matrimonial'
		// en el typed query solo esta retornando los datos de hotel, en cambio arriba
		// retorna todo tanto hotel como habitacion
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel AND ha.tipo = :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
//	@Transactional(value= TxType.MANDATORY)
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion) {
		log.info("Transaccion activa repository: "
				+ org.springframework.transaction.support.TransactionSynchronizationManager
						.isActualTransactionActive());
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo = :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}

	@Override
	public Hotel buscarHotel(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public int actualizarHotel(String nombre, String direccion) {
		// TODO Auto-generated method stub
		// UPDATE Hotel SET hote_nombre='Hotel Atacames' WHERE hote_direccion='Amanta'
	Query myQueryv4 = this.entityManager
				.createQuery("UPDATE Hotel h SET h.nombre=:datoNombre WHERE h.direccion =:datoDireccion");
		myQueryv4.setParameter("datoNombre", nombre);
		myQueryv4.setParameter("datoDireccion", direccion);
		return myQueryv4.executeUpdate();
	}

	@Override
	public int eliminarHotel(String direccion) {
		// TODO Auto-generated method stub
		// DELETE FROM Hotel WHERE hote_direccion='Shirys'
		Query myQueryV5 = this.entityManager.createQuery("DELETE FROM Hotel h WHERE h.direccion =: direccion");
		myQueryV5.setParameter("direccion", direccion);
		return myQueryV5.executeUpdate();
	}

}
