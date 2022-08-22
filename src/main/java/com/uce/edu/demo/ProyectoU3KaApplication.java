package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.repository.IFacturaRepository;
import com.uce.edu.demo.cajero.repository.modelo.DetalleFactura;
import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.service.IClienteService;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.IProductoService;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3KaApplication implements CommandLineRunner {

	private static final Logger log = Logger.getRootLogger();

	@Autowired
	private IClienteService iClienteService;
	
	@Autowired
	private IFacturaService iFacturaService;
	
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
		p.setCodigo("2321");
		p.setNombre("Coca");
		p.setPrecio(new BigDecimal(20));
		p.setStock(100);
		this.iProductoService.insertar(p);
		
		Producto p1 = new Producto();
		p1.setCodigo("2321321");
		p1.setNombre("Pan");
		p1.setPrecio(new BigDecimal(1));
		p1.setStock(50);
		this.iProductoService.insertar(p1);
		
		
		
		
		
		
	
	}
}
