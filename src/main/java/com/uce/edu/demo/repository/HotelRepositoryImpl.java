package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.reactive.TransactionSynchronizationManager;

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
		//SE PUEDE PONER INNER JOIN O SOLO JOIN
		// la plabara habitaciones es el nombre de la referencia que dimos en Hotel
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo = :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		
		//para que traiga las habiatciones usando lazy en la clase y usamos size para garantizarnos que traiga las habitaciones SOLO EN EL REPOSITORY
		List<Hotel> hoteles = myQuery.getResultList();
		for(Hotel h : hoteles) {
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
		//SELECT * FROM hotel ho, habiotacion ha where ho.hote_id =  ha.habi_id_hotel and ha.habi_tipo = 'Matrimonial'
		//en el typed query solo esta retornando los datos de hotel, en cambio arriba retorna todo tanto hotel como habitacion
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel AND ha.tipo = :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
//	@Transactional(value= TxType.MANDATORY)
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion) {
		log.info("Transaccion activa repository: "+org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive() );
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo = :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

}
