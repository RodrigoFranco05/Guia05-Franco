package Ejercicio1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler implements Contratable {
	
	private Herramienta herramienta;
	private LocalDate dia_inicio;
	private LocalDate dia_final;
	private LocalDate fecha_devolucion;
	
	public Alquiler(Herramienta herramienta,LocalDate dia_inicio,LocalDate dia_final) {
		this.herramienta = herramienta;
		this.dia_inicio=dia_inicio;
		this.dia_final=dia_final;
	}

	public double alquiler() {
		LocalDate hoy;
		double costo;
		long dias;
		
		if(this.fecha_devolucion==null) {
			
			hoy=LocalDate.now();
			
			dias=ChronoUnit.DAYS.between(dia_inicio,hoy);;
			costo=dias* this.herramienta.getCostodia();
			
			this.fecha_devolucion =null;
		}
		else {
			dias = ChronoUnit.DAYS.between(dia_inicio,dia_final);
			costo=dias * this.herramienta.getCostodia();

		}
		return costo;
	}
	

	public boolean enMora() {
		if (this.fecha_devolucion == null) {
			if(this.dia_final.compareTo(LocalDate.now())<0) {
				return true;
			}
			else {
				return false;
			}
		}
		
		else if (this.dia_final.compareTo(fecha_devolucion)<0) {
			return true;
		}
		
		else {
			return false;
		}
	}

	
	public boolean finalizado() {
		if (this.fecha_devolucion==null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void devolver() {
		this.fecha_devolucion= LocalDate.now();
		return;
	}
}
