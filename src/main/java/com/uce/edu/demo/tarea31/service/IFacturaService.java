package com.uce.edu.demo.tarea31.service;

import java.math.BigDecimal;
import java.util.List;

public interface IFacturaService {
	
	public BigDecimal generar (String cedula, String numeroFactura, List<String>codigos);

}