package com.uce.edu.demo.service.tarea.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static final Logger log = Logger.getRootLogger();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MetodosHighOrderTarea metodosHO = new MetodosHighOrderTarea();

		// ---------------------------------------------SUPPLIER------------------------------------------------------

		// Clases

		IEstudianteSupplier<String> supplierClase = new EstudianteSupplierImpl();
		log.info("Supplier Clase Tarea: " + supplierClase.getNombre());

		// Lambdas

		IEstudianteSupplier<String> supplierLambdas = () -> "Pedro Pablo";
		log.info("Supplier Lambda Tarea: " + supplierLambdas.getNombre());

		// Metodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> "Probando Lambas");
		log.info("High Order Supplier Tarea" + valorHO);

		String valorHO1 = metodosHO.consumirSupplier(() -> {
			String valorConsultado = "32";
			String valorFinal = valorConsultado.concat("concatenando...");
			return valorFinal;
		});
		log.info("High Order Supplier Tarea" + valorHO1);
//
		// ------------------------------------------------------CONSUMER------------------------------------------------------
//
		// Clases

		IEstudianteConsumer<String> consumerClase = new EstudianteConsumerImpl();
		consumerClase.accept("Consumer para la tarea");

		// Lambdas

		IEstudianteConsumer<String> consumerLamba = cadena -> System.out.println(cadena);
		consumerLamba.accept("Consumer para la tarea con Lambdas");

		// Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 23);

//		// ------------------------------------------------------PREDICATE------------------------------------------------------
//
		// Clases
		IEstudiantePredicate<String> predicateClase = new EstudiantePredicateImpl();
		boolean valorImprimir = predicateClase.evaluar("Xavier");
		log.info("predicate Clase Tarea: " + valorImprimir );
		// Lambdas

		IEstudiantePredicate<String> predicateLamba = cadena -> cadena.contains("P");
		log.info("predicate Lamba Tarea: " + predicateLamba.evaluar("Xavier"));

		// Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("P"), "XavierP");
		log.info("High Order predicate " + respuesta);
////		// ------------------------------------------------------FUNCTION------------------------------------------------------
////
		// Clases
		IEstudianteFunction<String, Integer> functionPredicate = new EstudianteFunctionImpl<>();
		String funcionImprimir = functionPredicate.aplicar(23);
		log.info("Function clase: el numero es: "+ funcionImprimir);
		

		// Lambdas

		IEstudianteFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			if (valorFinal < 23) {
				log.info("Function: Si cumple con la condicion");
				return valorFinal;
			} else {
				log.info("Function: No cumple con la condicion");
				return valorFinal + 30;
			}

		};

		log.info("function Lamba: " + functionLambda.aplicar("7"));

		// Metodos High Order
		String valorFinalHO = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + "Ingresando datos en Function";
			return retorno;
		}, 1);
		log.info("High Order function " + valorFinalHO);
//		// ------------------------------------------------------UNARY OPERATOR
//		// (FUNCTION)------------------------------------------------------
//
		// Clases
		IEstudianteFunctionUnaryOperator<String> functionUnaryOperator = new EstudianteFunctionUnaryOperatorImpl();
		String ValorPrueba = functionUnaryOperator.aplicar("Probando Unary Operator para deber");
		log.info(ValorPrueba);

		// Lambdas

		IEstudianteFunctionUnaryOperator<String> unaryLambda = cadena -> {
			String valorFinal = cadena.concat("Pruebas de los lambdas");
			return valorFinal;
		};
		log.info("unary Lamba: " + unaryLambda.aplicar("Xavier"));

		// Metodos High Order
		String valorFinalHO1 = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + "Ingresando para UnaryOperator";
			return retorno;
		}, 1);
		log.info("High Order function " + valorFinalHO1);
	}

}
