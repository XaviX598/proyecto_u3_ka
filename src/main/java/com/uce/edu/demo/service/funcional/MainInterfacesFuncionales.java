package com.uce.edu.demo.service.funcional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static final Logger log = Logger.getRootLogger();

	public static boolean prueba(Integer numero) {
		return numero >= 3;
	}

	public static void imprimir(String cadena) {
		log.info("Impresion: " + cadena);
	}

	public static void guardar(String elementoAInsertar) {
		// Consumo del repository a insertar
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();

		// ---------------------------------------------SUPPLIER------------------------------------------------------

		// Clases

		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
		log.info("Supplier Clase: " + supplierClase.getNombre());

		IPersonaSupplier<String> supplierTE = new PersonaSupplierTEImpl();
		log.info("Supplier Clase: " + supplierTE.getNombre());

		// Lambdas

		// !!!!no recibe argumentos y por eso ()!!!!
		IPersonaSupplier<String> supplierLambdas = () -> "Xavier 2";
		log.info("Supplier Lambda: " + supplierLambdas.getNombre());

		IPersonaSupplier<String> supplierLambdasTE = () -> "Daniel TE 2";
		log.info("Supplier Lambda: " + supplierLambdasTE.getNombre());

		// Metodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> "Hola mundo");
		log.info("High Order Supplier " + valorHO);

		String valorHO1 = metodosHO.consumirSupplier(() -> {
			String valorConsultado = "213213234";
			return valorConsultado;
		});
		log.info("High Order Supplier " + valorHO1);

		// JAVA
		
		// STREAM Es una propuesta de Java para programacion funcional en colecciones,
		// todos estos tienen metodos HO, debemos trabajar con Stram para procesar info,
		// un STREAM esta preparado para hacer la ejecucion de un progrrama mucho mas
		// eficiente
		
		log.info("JAVA SUPPLIER");
		Stream<String> test = Stream.generate(() -> "Xavier 2").limit(7);
		test.forEach(cadena -> System.out.println(cadena));

		// ------------------------------------------------------CONSUMER------------------------------------------------------

		// Clases

		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");

		// Lambdas

		IPersonaConsumer<String> consumerLamba = cadena -> System.out.println(cadena);
		consumerLamba.accept("Prueba Consumer Lambda");

		// Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);

		// JAVA
		log.info("JAVA CONSUMER");
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5);
		listaNumeros.forEach(numero -> System.out.println(numero));

		// ------------------------------------------------------PREDICATE------------------------------------------------------

		// Clases

		// Lambdas

		// despuies de -> debe ir un boolean en este caso el contaisn de si contiene el
		// String en este caso es false ya que Xavier no contiene Z pero si mandamos
		// XavierZ da true
		IPersonaPredicate<String> predicateLamba = cadena -> cadena.contains("Z");
		log.info("predicate Lamba: " + predicateLamba.evaluar("Xavier"));

		// Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("Z"), "XavierZ");
		log.info("High Order predicate " + respuesta);

		// JAVA
		// CUANDO QUERAMOS REVISAR UNA CONSIDICON SE USA ESTA INTERFAZ EN JAVA PARA
		// FILTRAR INFORMACION
		log.info("JAVA PREDICATE");
		Stream<Integer> nuevaLista = listaNumeros.stream().filter(numero -> numero >= 3);
		nuevaLista.forEach(numero -> System.out.println(numero));
		// O
		System.out.println("Mediante un metodo");
		Stream<Integer> nuevaLista1 = listaNumeros.stream().filter(numero -> prueba(numero));
		nuevaLista1.forEach(numero -> System.out.println(numero));

		// ------------------------------------------------------FUNCTION------------------------------------------------------

		// Clases

		// Lambdas

		IPersonaFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			return valorFinal;
		};

		log.info("function Lamba: " + functionLambda.aplicar("7"));

		// Metodos High Order
		String valorFinalHO = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + "A";
			return retorno;
		}, 1);
		log.info("High Order function " + valorFinalHO);

		// JAVA
		// CUANDO QUERAMOS REVISAR UNA CONSIDICON SE USA ESTA INTERFAZ EN JAVA PARA
		// FILTRAR INFORMACION
		log.info("JAVA FUNCTION");
		// Conversiones/cast Empleado -> EmpleadoDTO o ligero
		Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> {
			Integer valor = numeroLista + 1;
			String cadena = "num: " + valor.toString();
			return cadena;
		});
		// DECLARATIVA : ideas/inten
		listaCambiada.forEach(valor -> System.out.println(valor));
		// O
		Stream<String> listaCambiada1 = listaNumeros.stream().map(numeroLista -> {
			Integer valor = numeroLista + 1;
			String cadena = "num: " + valor.toString();
			return cadena;
		});
		listaCambiada1.forEach(valor -> imprimir(valor));
		
		//TODAS SON COLEECIONES TANTO 
//		List<String> lista1 = new ArrayList<>();
//		Map<String, String > mpa1= new HashMap<String, String>();
		//al igual que el STREAM pero esta es mas eficiente y tiene mejor rendimiento que las demas 

		// IMPERATIVA: paso a paso
//		for(String valor:) {
//			imprimir(valor);
//		}

		// ------------------------------------------------------UNARY OPERATOR
		// (FUNCTION)------------------------------------------------------

		// Clases

		// Lambdas

		IPersonaFunctionUnaryOperator<String> unaryLambda = cadena -> {
			String valorFinal = cadena.concat("sufijo");
			return valorFinal;
		};
		log.info("unary Lamba: " + unaryLambda.aplicar("Xavier"));

	}

}
