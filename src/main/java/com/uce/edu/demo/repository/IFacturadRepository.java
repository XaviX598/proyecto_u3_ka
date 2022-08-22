package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturadRepository {
	

	public void insertar(Factura factura);

	public void actualizar(Factura factura);

	public void eliminar(Integer id);

	public Factura buscar(Integer id);
	
	public int actualizarFecha(LocalDateTime fecha);
	
	public Factura buscarNumero(String numero);
	
	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal);

	public List<Factura> buscarFacturaInnerJoin();

	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal subtotal);

	public List<Factura> buscarFacturaOuterJoinLeft();

	public List<Factura> buscarFacturaOuterJoinRight(BigDecimal subtotal);

	public List<Factura> buscarFacturaJoinWhere(BigDecimal subtotal);

	public List<Factura> buscarFacturaFetchJoin(BigDecimal subtotal);

	

}
