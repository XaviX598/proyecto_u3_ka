package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static final Logger log = Logger.getRootLogger();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConsumoMetodosHighOrder metodosHO= new ConsumoMetodosHighOrder();

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
		
		//Metodos High Order
		String valorHO = metodosHO.consumirSupplier( () -> "Hola mundo" );
		log.info("High Order Supplier " + valorHO);
		
		String valorHO1 = metodosHO.consumirSupplier( () -> {
			String valorConsultado = "213213234";
			return valorConsultado;}
		);
		log.info("High Order Supplier " + valorHO1);
		
		// ------------------------------------------------------CONSUMER------------------------------------------------------
		
		// Clases
		
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
		
		
		// Lambdas

		IPersonaConsumer<String> consumerLamba = cadena -> System.out.println(cadena);
		consumerLamba.accept("Prueba Consumer Lambda");
		
		
		//Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);
		
		
		// ------------------------------------------------------PREDICATE------------------------------------------------------

		// Clases

		// Lambdas
		
		// despuies de -> debe ir un boolean  en este caso el contaisn de si contiene el String en este caso es false ya que Xavier no contiene Z pero si mandamos XavierZ da true
		IPersonaPredicate<String> predicateLamba = cadena -> cadena.contains("Z");
		log.info("predicate Lamba: "+ predicateLamba.evaluar("Xavier"));
		
		//Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("Z"), "XavierZ");
		log.info("High Order predicate " + respuesta);
		// ------------------------------------------------------FUNCTION------------------------------------------------------

		// Clases

		// Lambdas

		IPersonaFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor -2;
			return valorFinal;
		};
		
		log.info("function Lamba: "+ functionLambda.aplicar("7"));
		
		//Metodos High Order
		String valorFinalHO= metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString()+"A";
			return retorno ;
		}, 1);
		log.info("High Order function " + valorFinalHO);
		// ------------------------------------------------------UNARY OPERATOR
		// (FUNCTION)------------------------------------------------------

		// Clases

		// Lambdas
		
		IPersonaFunctionUnaryOperator<String> unaryLambda =  cadena -> {
			String valorFinal=cadena.concat("sufijo");
			return valorFinal;
		};
		log.info("unary Lamba: "+ unaryLambda.aplicar("Xavier"));

	}

}
