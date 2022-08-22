package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturadRepository;
import com.uce.edu.demo.repository.modelo.Factura;

@Service
public class FacturadServiceImpl implements IFacturadService
{
	@Autowired
	private IFacturadRepository iFacturadRepository;

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.iFacturadRepository.insertar(factura);
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.iFacturadRepository.actualizar(factura);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iFacturadRepository.eliminar(id);
	}

	@Override
	public Factura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iFacturadRepository.buscar(id);
	}

	@Override
	public int actualizarFecha(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.iFacturadRepository.actualizarFecha(fecha);
	}

	@Override
	public Factura buscarNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iFacturadRepository.buscarNumero(numero);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.iFacturadRepository.buscarFacturaInnerJoin(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.iFacturadRepository.buscarFacturaInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.iFacturadRepository.buscarFacturaOuterJoinLeft(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.iFacturadRepository.buscarFacturaOuterJoinLeft();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.iFacturadRepository.buscarFacturaOuterJoinRight(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.iFacturadRepository.buscarFacturaJoinWhere(subtotal);
	}

	@Override
	public List<Factura> buscarFacturaFetchJoin(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		return this.iFacturadRepository.buscarFacturaFetchJoin(subtotal);
	}

}
