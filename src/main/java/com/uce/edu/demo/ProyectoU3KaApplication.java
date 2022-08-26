package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea31.repository.modelo.Cliente;
import com.uce.edu.demo.tarea31.repository.modelo.Producto;
import com.uce.edu.demo.tarea31.service.IClienteService;
import com.uce.edu.demo.tarea31.service.IFacturaService;
import com.uce.edu.demo.tarea31.service.IProductoService;


@SpringBootApplication
public class ProyectoU3KaApplication implements CommandLineRunner {

	private static final Logger log = Logger.getRootLogger();

	@Autowired
	private IClienteService iClienteService;
	
	@Autowired
	private IFacturaService iFacturadService;
	
	@Autowired
	private IProductoService iProductoService;
	

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3KaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cliente c = new Cliente();
		c.setApellido("Aguilar");
		c.setCedula("223234231");
		c.setNombre("Xavier");
		c.setNumeroTarjeta("23121321");
		
		this.iClienteService.insertar(c);
		
		Producto p = new Producto();
		p.setNumero("2321");
		p.setNombre("Coca");
		p.setPrecio(new BigDecimal(20));
		p.setStock(100);
		this.iProductoService.insertar(p);
		
		Producto p1 = new Producto();
		p1.setNumero("2321321");
		p1.setNombre("Pan");
		p1.setPrecio(new BigDecimal(1));
		p1.setStock(50);
		this.iProductoService.insertar(p1);
		
		Producto p2 = new Producto();
		p2.setNumero("4564561561");
		p2.setNombre("Salchichas");
		p2.setPrecio(new BigDecimal(5.60));
		p2.setStock(100);
		this.iProductoService.insertar(p2);
		
		Producto p3 = new Producto();
		p3.setNumero("48941414");
		p3.setNombre("Nachos");
		p3.setPrecio(new BigDecimal(2.50));
		p3.setStock(30);
		this.iProductoService.insertar(p3);
		
		
		List<String> detalles = new ArrayList<>();
		detalles.add(p.getNumero());
		detalles.add(p1.getNumero());
		detalles.add(p2.getNumero());
		detalles.add(p3.getNumero());
		this.iFacturadService.generar(c.getCedula(), "45454", detalles);
		
		
		
		
		
		
	
	}
}
