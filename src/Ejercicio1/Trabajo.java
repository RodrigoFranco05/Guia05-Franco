package Ejercicio1;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Trabajo {
	Servicio servicio;
	Trabajador trabajador;
	LocalDate fecha_servicio;
	LocalDate fecha_inicio;
	LocalDate fecha_fin;
	
	public Trabajo(Servicio servicio, LocalDate fecha_servicio) {
		this.servicio=servicio;
		this.fecha_servicio=fecha_servicio;
		
	}
	
	public LocalDate getFechaServicio() {
		return this.fecha_servicio;
	}
	
	public Servicio getServicio() {
		return this.servicio;
	}
	
	public void finalizar() {
		this.fecha_fin = LocalDate.now();
	}
	
	public boolean finalizado() {
		
		return (fecha_fin != null);
		
	}
	
	public LocalDate getFechaInicio() {
		return this.fecha_inicio;
	}
	
	public double costoTrabajador(){
		double costo_final;
		if(fecha_fin != null) {
			int horaInicio = Integer.parseInt(this.fecha_inicio.format(DateTimeFormatter.ofPattern("H")));
			int horaFin = Integer.parseInt(this.fecha_fin.format(DateTimeFormatter.ofPattern("H")));
			
			
			costo_final= horaFin - horaInicio * trabajador.getCosto_hora();
			
		}
		else {
			costo_final=0; //exep 
		}
		return costo_final;
	}
}
