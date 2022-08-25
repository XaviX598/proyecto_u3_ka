package com.uce.edu.demo.service.tarea.funcional;

public class EstudianteFunctionUnaryOperatorImpl implements IEstudianteFunctionUnaryOperator<String>{

	@Override
	public String aplicar(String arg1) {
		// TODO Auto-generated method stub
		String cadenaFinal= arg1.concat(" Prueba completada");
		
		return cadenaFinal;
	}

}
