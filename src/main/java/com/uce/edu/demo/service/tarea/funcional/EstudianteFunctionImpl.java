package com.uce.edu.demo.service.tarea.funcional;

public class EstudianteFunctionImpl<String> implements IEstudianteFunction<String, Integer>{

	@Override
	public String aplicar(Integer arg1) {
		// TODO Auto-generated method stub
		String valor =  (String) arg1.toString();
		
		return valor;
	}

}
