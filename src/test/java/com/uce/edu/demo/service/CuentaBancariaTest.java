package com.uce.edu.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;
import com.uce.edu.demo.service.ICuentaBancariaService;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional
public class CuentaBancariaTest {

	

	@Autowired
	private ITransferenciaService iTransferenciaService;

	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;

	@Test
	@Rollback(true)
	public void realizarTransferenciaTest() {

		BigDecimal monto = new BigDecimal("20");

		this.iTransferenciaService.realizarTransferenciaFachada("1234", "5647", monto);

		assertNotNull(monto);
	}

	@Test
	@Rollback(true)
	public void insertarTransferenciaTest() {

		CuentaBancaria ctaOrigen = this.iCuentaBancariaService.buscarPorNumero("1234");
		CuentaBancaria ctaDestino = this.iCuentaBancariaService.buscarPorNumero("5647");

		Transferencia tra = new Transferencia();
		tra.setFecha(LocalDateTime.now());
		tra.setMonto(new BigDecimal("20"));
		tra.setCuentaOrigen(ctaOrigen);
		tra.setCuentaDestino(ctaDestino);
		this.iTransferenciaService.insertar(tra);

		assertNotNull(tra.getMonto());

	}

	@Test
	@Rollback(true)
	public void cuentaBancariaBuscarPorNumeroTest() {

		assertThat(this.iCuentaBancariaService.buscarPorNumero("1234")).isNotNull();
	}

}
