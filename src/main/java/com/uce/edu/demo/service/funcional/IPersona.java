package com.uce.edu.demo.service.funcional;
@FunctionalInterface
//una interfax funcional solo tine o expresa una unica funcion pero solo es UNA CARACTERISTICA
// si omitimos la anotacion y solo tenemos un metodo, no dejaria de ser una interfaz funcional ya que solot endria una funcionalidad
public interface IPersona {
	
	public String comer();
	
	//public String caminar();

}
