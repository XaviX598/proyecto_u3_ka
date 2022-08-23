package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static final Logger log = Logger.getRootLogger();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ---------------------------------------------SUPPLIER------------------------------------------------------

		// Clases
		
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
		log.info("Supplier Clase: " + supplierClase.getNombre());
		
		IPersonaSupplier<String> supplierTE = new PersonaSupplierTEImpl();
		log.info("Supplier Clase: " + supplierTE.getNombre());
		
		// Lambdas
		
		//!!!!no recibe argumentos y por eso ()!!!!
		IPersonaSupplier<String> supplierLambdas = () -> "Xavier 2";
		log.info("Supplier Lambda: " + supplierLambdas.getNombre());
		
		IPersonaSupplier<String> supplierLambdasTE = () -> "Daniel TE 2";
		log.info("Supplier Lambda: " + supplierLambdasTE.getNombre());
			
		
		// ------------------------------------------------------CONSUMER------------------------------------------------------
		
		// Clases
		
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
		
		// Lambdas

		IPersonaConsumer<String> consumerLamba = cadena -> System.out.println(cadena);
		consumerLamba.accept("Prueba Consumer Lambda");
		
		// ------------------------------------------------------PREDICATE------------------------------------------------------

		// Clases

		// Lambdas

		// ------------------------------------------------------FUNCTION------------------------------------------------------

		// Clases

		// Lambdas

		// ------------------------------------------------------UNARY OPERATOR
		// (FUNCTION)------------------------------------------------------

		// Clases

		// Lambdas

	}

}
