package com.uce.edu.demo.tarea31.service;

import java.util.List;

public interface IGestorService {
	
	public void generarFacturaElectronicaSRI(String cedula, String numeroFactura, List<String>codigos);

}
