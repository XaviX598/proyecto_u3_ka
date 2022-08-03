package com.uce.edu.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.Logger;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3KaApplication implements CommandLineRunner {

	private static final Logger log = Logger.getRootLogger();

	@Autowired
	private IHotelService iHotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3KaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("INNER JOIN");
		List<Hotel> listaHoteles = this.iHotelService.buscarHotelInnerJoin("Familiar");
		for (Hotel item : listaHoteles) {
			log.info("Hotel:" + item.getNombre() + " " + item.getDireccion());
		}
		
		log.info("INNER JOIN sin argumento");
		List<Hotel> listaHotelesSN = this.iHotelService.buscarHotelInnerJoin();
		for (Hotel item : listaHotelesSN) {
			log.info("Hotel:" + item.getNombre() + " " + item.getDireccion());
		}
		
		log.info("LEFT JOIN");
		List<Hotel> listaHotelesLeft = this.iHotelService.buscarHotelOuterJoinLeft("Familiar");
		for (Hotel item : listaHotelesLeft) {
			log.info("Hotel:" + item.getNombre() + " " + item.getDireccion());
		}
		
		log.info("LEFT JOIN sin argumentos");
		List<Hotel> listaHotelesLeftSN = this.iHotelService.buscarHotelOuterJoinLeft();
		for (Hotel item : listaHotelesLeftSN) {
			log.info("Hotel:" + item.getNombre() + " " + item.getDireccion());
		}
		
		log.info("RIGHT JOIN");
		List<Hotel> listaHotelesRight = this.iHotelService.buscarHotelOuterJoinRight("Familiar");
		for (Hotel item : listaHotelesRight) {
			log.info("Hotel:" + item.getNombre() + " " + item.getDireccion());
		}

	}

}
