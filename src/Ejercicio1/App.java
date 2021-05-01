package Ejercicio1;

import Exepciones.*;
import java.time.LocalDate;

public class App {
	
	public static void main (String[] args) {
	
		
		/*Se crean los usuario*/
		Usuario user = new Usuario("Rodrigo Franco", "rodri.franco05@gmail.com");
		
		
		
		/*Se crean los trabajadores*/
		Trabajador trabajador1 = new Trabajador("Nicolas Gorla","nicogorla@gmail.com","CARPINTERIA",300);
		Trabajador trabajador2 = new Trabajador("Francisco Mendoza","franmendozaz@gmail.com","CERRAJERIA",100);
		
		
		
		/*Se crean los servicios*/
		Servicio servicio1 = new ServicioEstandar("CARPINTERIA","Reparacion", LocalDate.now(),2000);
		Servicio servicio2 = new ServicioEstandar("CERRAJERIA","Reparacion", LocalDate.now(),1200);
		Servicio servicio3 = new ServicioPersonalizado("CARPINTERIA","Reparacion", LocalDate.now(),1000,500,500);
		Servicio servicio4 = new ServicioPersonalizado("CERRAJERIA","Reparacion", LocalDate.parse("2021-04-25"),2500,100,500);
		
		
		
		/*Se crean las herramientas*/
		Herramienta herramienta1 = new Herramienta("Destornillador plano",50);
		Herramienta herramienta2 = new Herramienta("Cinta Metrica",25);
		Herramienta herramienta3 = new Herramienta("Pinza",20);
		Herramienta herramienta4 = new Herramienta("Metro",50);	
		
		
		
		/*Se crean los alquileres */
		Alquiler alquiler1 = new Alquiler(herramienta1, LocalDate.parse("2021-04-10"),LocalDate.parse("2021-04-20"));
		Alquiler alquiler2 = new Alquiler(herramienta2, LocalDate.parse("2021-04-10"),LocalDate.parse("2021-04-20"));
		Alquiler alquiler3 = new Alquiler(herramienta3, LocalDate.parse("2021-04-10"),LocalDate.parse("2021-04-20"));
		Alquiler alquiler4 = new Alquiler(herramienta4, LocalDate.now(),LocalDate.parse("2021-04-27"));
		
		
		
		
		/*El usuario contrata los servicios*/
		try { 
			user.contratar(servicio1);
			System.out.println("Servicio contratado con exito!");
			
		}
		catch (AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		try { 
			user.contratar(servicio2);
			System.out.println("Servicio contratado con exito!");
		}
		catch (AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		try { 
			user.contratar(servicio3);
			System.out.println("Servicio contratado con exito!");
		}
		catch (AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		try { 
			user.contratar(servicio4);
			System.out.println("Servicio contratado con exito!");
		}
		catch (AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}

		
		
		//OficioNoCoincideException
		try {	
			trabajador2.asignartrabajo(servicio1);
			System.out.println("Trabajo agregado al trabajador 2");
			
		
			System.out.println("Total a pagar por el trabajo 2: $"+trabajador2.calcular_costo(servicio1));
		}
		catch(AgendaOcupadaException | OficioNoCoincideException e) {
			e.printStackTrace();
		}
		
		//En este trabajador puede agregarse la tarea, por lo tanto, se almacena
		
		try { 
			trabajador1.asignartrabajo(servicio1);
			System.out.println("Trabajo agregado al trabajador 1");
			
			System.out.println("Total a pagar por el trabajo 2: $"+trabajador1.calcular_costo(servicio1));
		}
		catch(AgendaOcupadaException | OficioNoCoincideException e) {
			e.printStackTrace();
		}

		
		//AgendaOcupadaException
		try {
			trabajador1.calcular_costo((ServicioPersonalizado)servicio3);
			trabajador1.asignartrabajo(servicio3);
			System.out.println("Trabajo agregado al trabajador 1");
			System.out.println("Total a pagar por el trabajo 2: $"+trabajador1.calcular_costo(servicio3));
		}
		catch(AgendaOcupadaException | OficioNoCoincideException e) {
			e.printStackTrace();
		}
		
		//En este caso el trabajador puede almacenar tanto el servicio 2 como el 4 porque no se superponen sus fechas
		try {
			trabajador2.asignartrabajo(servicio2);
			System.out.println("Trabajo agregado al trabajador 2");
			System.out.println("Total a pagar por el trabajo 2: $"+trabajador2.calcular_costo(servicio2));
		}
		
		catch(AgendaOcupadaException | OficioNoCoincideException e) {
			e.printStackTrace();
		}
		
		
		
		
		//Se alquilan herramientas
		try {
			user.contratar(alquiler1);
			System.out.println("Herramienta 1 alquilada con exito!");
		}
		catch(AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		try {
			user.contratar(alquiler2);
			System.out.println("Herramienta 2 alquilada con exito!");
		}
		catch(AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		try {
			user.contratar(alquiler3);
			System.out.println("Herramienta 3 alquilada con exito!");
		}
		catch(AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		
		
		//AlquierNoEntregadoException
		try {
			user.contratar(alquiler4);
			System.out.println("Herramienta 3 alquilada con exito!");
		}
		catch(AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		
		try {//Se devuelve uno de los alquileres que se encuetran demorados
			user.devolver(alquiler1);
			System.out.println("La herramienta 1 fue devuelta con demora exitosamente!");
			
			//Como solo existen dos alquileres demorados podra alquilar una nueva herramienta sin problemas
			user.contratar(alquiler4);
			System.out.println("Herramienta 4 alquilada con exito!");
			
		}
		catch(AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
	}
}
	
	
