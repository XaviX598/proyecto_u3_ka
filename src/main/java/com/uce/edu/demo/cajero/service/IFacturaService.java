package com.uce.edu.demo.cajero.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.demo.cajero.repository.modelo.Factura;

public interface IFacturaService {
	
	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal);

	public List<Factura> buscarFacturaInnerJoin();

	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal subtotal);

	public List<Factura> buscarFacturaOuterJoinLeft();

	public List<Factura> buscarFacturaOuterJoinRight(BigDecimal subtotal);

	public List<Factura> buscarFacturaJoinWhere(BigDecimal subtotal);

	public List<Factura> buscarFacturaFetchJoin(BigDecimal subtotal);

}
