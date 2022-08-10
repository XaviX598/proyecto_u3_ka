package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;
@Service
public class TransferenciaServiceImpl implements ITransferenciaService {
	
	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository; 
	
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		
		//0.Busque la cta origen
		CuentaBancaria ctaOrigen=this.iCuentaBancariaRepository.buscarPorNumero(numeroCtaOrigen);
		//1.Restar cta Origen
		BigDecimal saldoOrigen = ctaOrigen.getMonto();
		BigDecimal saldoFinal = saldoOrigen.subtract(monto);
		ctaOrigen.setMonto(saldoFinal);
		this.iCuentaBancariaRepository.actualizar(ctaOrigen);
		//2.Busque la cta Destino
		CuentaBancaria ctaDestino = this.iCuentaBancariaRepository.buscarPorNumero(numeroCtaDestino);
		//3.Sumar cta Destino
		ctaDestino.setMonto(ctaDestino.getMonto().add(monto));
		this.iCuentaBancariaRepository.actualizar(ctaDestino);
		//4.Insertar transferencia
		Transferencia trans = new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		trans.setCuentaOrigen(ctaOrigen);
		trans.setCuentaDestino(ctaDestino);
		this.iTransferenciaRepository.insertar(trans);
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void realizarTransferenciaFachada(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		this.realizarTransferencia(ctaOrigen, ctaDestino, monto);
	}

	

}
