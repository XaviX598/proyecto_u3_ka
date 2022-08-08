package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.repository.IFacturaRepository;
import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;
import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3KaApplication implements CommandLineRunner {

	private static final Logger log = Logger.getRootLogger();

//	@Autowired
//	private IHotelService iHotelService;
	
	@Autowired
	private IFacturaService iFacturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3KaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		log.info("INNER JOIN");
//		List<Hotel> listaHoteles = this.iHotelService.buscarHotelInnerJoin("Familiar");
//		for (Hotel item : listaHoteles) {
//			log.info("Hotel:" + item.getNombre() + " " + item.getDireccion());
//		}
//		
//		log.info("INNER JOIN sin argumento");
//		List<Hotel> listaHotelesSN = this.iHotelService.buscarHotelInnerJoin();
//		for (Hotel item : listaHotelesSN) {
//			log.info("Hotel:" + item.getNombre() + " " + item.getDireccion());
//		}
//		
//		log.info("LEFT JOIN");
//		List<Hotel> listaHotelesLeft = this.iHotelService.buscarHotelOuterJoinLeft("Familiar");
//		for (Hotel item : listaHotelesLeft) {
//			log.info("Hotel:" + item.getNombre() + " " + item.getDireccion());
//		}
//		
//		log.info("LEFT JOIN sin argumentos");
//		List<Hotel> listaHotelesLeftSN = this.iHotelService.buscarHotelOuterJoinLeft();
//		for (Hotel item : listaHotelesLeftSN) {
//			log.info("Hotel:" + item.getNombre() + " " + item.getDireccion());
//		}
//		
//		log.info("RIGHT JOIN");
//		List<Hotel> listaHotelesRight = this.iHotelService.buscarHotelOuterJoinRight("Familiar");
//		for (Hotel item : listaHotelesRight) {
//			log.info("Hotel:" + item.getNombre() + " " + item.getDireccion());
//		}
//		
//		log.info("JOIN WHERE");
//		List<Hotel> listaHotelesWhere = this.iHotelService.buscarHotelJoinWhere("Matrimonial");
//		for (Hotel item : listaHotelesWhere) {
//			log.info("Hotel:" + item.getNombre() + " " + item.getDireccion());
//		}
//		
//		log.info("INNER JOIN EAGER/LAZY");
//		List<Hotel> listaHotelesEagerLazy = this.iHotelService.buscarHotelInnerJoin("Familiar");
//		for (Hotel item : listaHotelesEagerLazy) {
//			log.info("Hotel usando Eager/Lazy: " + item.getNombre() + " " + item.getDireccion());
//			for(Habitacion ha : item.getHabitaciones()) {
//				log.info("Hotel usando Eager/Lazy Habitaciones: " + ha);
//			}	
//		
//		}
//		
//		log.info("JOIN FETCH");
//		List<Hotel> listaHotelesFecth = this.iHotelService.buscarHotelFetchJoin("Familiar");
//		for (Hotel item : listaHotelesFecth) {
//			log.info("Hotel usando Join Fetch: " + item.getNombre() + " " + item.getDireccion());
//			for(Habitacion ha : item.getHabitaciones()) {
//				log.info("Hotel usando Join Fetch Habitaciones: " + ha);
//			}	
//		
//		}
//		
		log.info("INNER JOIN");
		List<Factura> listaFacturas = this.iFacturaService.buscarFacturaInnerJoin(new BigDecimal(100));
		for (Factura item : listaFacturas) {
			log.info("Hotel:" + item);
		}
		
		log.info("INNER JOIN sin argumento");
		List<Factura> listaFacturas1 = this.iFacturaService.buscarFacturaInnerJoin(new BigDecimal(100));
		for (Factura item : listaFacturas1) {
			log.info("Hotel:" + item);
		}
		
		log.info("LEFT JOIN");
		List<Factura> listaFacturas2 = this.iFacturaService.buscarFacturaOuterJoinLeft(new BigDecimal(50));
		for (Factura item : listaFacturas2) {
			log.info("Hotel:" + item);
		}
		
		log.info("LEFT JOIN sin argumentos");
		List<Factura> listaFacturas3 = this.iFacturaService.buscarFacturaOuterJoinLeft(new BigDecimal(3.5));
		for (Factura item : listaFacturas3) {
			log.info("Hotel:" + item);
		}
		
		log.info("RIGHT JOIN");
		List<Factura> listaFacturas4 = this.iFacturaService.buscarFacturaOuterJoinRight(new BigDecimal(100));
		for (Factura item : listaFacturas4) {
			log.info("Hotel:" + item);
		}
		
		
	}
}
