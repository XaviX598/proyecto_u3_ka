package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository{
	
	private static final Logger LOG = Logger.getRootLogger();
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBancaria);
		//throw new RuntimeException();
	}

	@Override
    @Transactional(value =TxType.NOT_SUPPORTED)
    public CuentaBancaria buscarPorNumero(String numero) {
        LOG.info("Cuenta: "+org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive() );
        TypedQuery<CuentaBancaria> miTypedQuery = this.entityManager
                .createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero = :datoNumero", CuentaBancaria.class);
        miTypedQuery.setParameter("datoNumero", numero);
        return miTypedQuery.getSingleResult();
    }

}
