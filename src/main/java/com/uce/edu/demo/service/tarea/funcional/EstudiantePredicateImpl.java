package com.uce.edu.demo.service.tarea.funcional;

public class EstudiantePredicateImpl implements IEstudiantePredicate<String>{

	@Override
	public boolean evaluar(String arg1) {
		// TODO Auto-generated method stub
		if(arg1.equalsIgnoreCase("a")) {
			System.out.println("Verficando");
			return true;
		}else {
			System.out.println("Verficando");
			return false;
		}
		
		
	}

}
