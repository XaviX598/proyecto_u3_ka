package com.uce.edu.demo.service.tarea.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static final Logger log = Logger.getRootLogger();

	public static boolean prueba(String cadena) {
		return cadena.contains("P");
	}
	
	public static void imprimir(Integer valor) {
		log.info("Impresion: " + valor);
	}

	

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

		// JAVA

		log.info("JAVA SUPPLIER");
		for (int i = 1; i < 10; i++) {
			Stream<String> test = Stream.generate(() -> "Me voy a repetir muchas veces veces").limit(i);

			test.forEach(cadena -> System.out.println(cadena));
		}

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

		// JAVA
		log.info("JAVA CONSUMER");
		List<String> listado = Arrays.asList("Xavier", "Pedro", "Rom", "Juan", "Carolina");
		listado.forEach(cadena -> System.out.println(cadena));

//		// ------------------------------------------------------PREDICATE------------------------------------------------------
//
		// Clases
		IEstudiantePredicate<String> predicateClase = new EstudiantePredicateImpl();
		boolean valorImprimir = predicateClase.evaluar("Xavier");
		log.info("predicate Clase Tarea: " + valorImprimir);
		// Lambdas

		IEstudiantePredicate<String> predicateLamba = cadena -> cadena.contains("P");
		log.info("predicate Lamba Tarea: " + predicateLamba.evaluar("Xavier"));

		// Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("P"), "XavierP");
		log.info("High Order predicate " + respuesta);

		// JAVA

		log.info("JAVA PREDICATE");
		Stream<String> nuevaLista = listado.stream().filter(cadena -> cadena.contains("P"));
		nuevaLista.forEach(numero -> System.out.println(numero));

		// O

		System.out.println("Mediante un metodo");
		Stream<String> nuevaLista1 = listado.stream().filter(cadena -> prueba(cadena));
		nuevaLista1.forEach(cadena -> System.out.println(cadena));

////		// ------------------------------------------------------FUNCTION------------------------------------------------------
////
		// Clases
		IEstudianteFunction<String, Integer> functionPredicate = new EstudianteFunctionImpl<>();
		String funcionImprimir = functionPredicate.aplicar(23);
		log.info("Function clase: el numero es: " + funcionImprimir);

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
		
		log.info("JAVA CONSUMER USADO PARA FUNCTION");
		List<String> listaNumeros = Arrays.asList("1", "2", "3", "4", "5");
		listaNumeros.forEach(cadena -> System.out.println(cadena));

		// JAVA
		// CUANDO QUERAMOS REVISAR UNA CONSIDICON SE USA ESTA INTERFAZ EN JAVA PARA
		// FILTRAR INFORMACION
		log.info("JAVA FUNCTION");
		// Conversiones/cast Empleado -> EmpleadoDTO o ligero
		Stream<Integer> listaCambiada = listaNumeros.stream().map(cadena -> {
			String nuevaCadena = cadena.concat("23");
			Integer valor = Integer.parseInt(nuevaCadena);
			return valor;
		});
		// DECLARATIVA : ideas/inten
		listaCambiada.forEach(valor -> System.out.println(valor));
		// O
		Stream<Integer> listaCambiada1 = listaNumeros.stream().map(cadena -> {
			String nuevaCadena = cadena.concat("23");
			Integer valor = Integer.parseInt(nuevaCadena);
			return valor;
		});
		listaCambiada1.forEach(valor -> imprimir(valor));

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
