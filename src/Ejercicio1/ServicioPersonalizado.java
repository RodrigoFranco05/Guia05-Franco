package Ejercicio1;

import java.time.LocalDate;

public class ServicioPersonalizado extends Servicio {
	
	private double presupuesto;
	private double materiales;
	private double trasporte;
	
	
	public ServicioPersonalizado(String oficio,String tipoServicio,LocalDate fecha_inicio,double presupuesto,double materiales,double trasporte) {
		this.presupuesto=presupuesto;
		this.materiales=materiales;
		this.trasporte=trasporte;
		this.oficio=oficio;
		this.tipoServicio = tipoServicio;
		this.urgente=false;
		this.fecha_inicio=fecha_inicio;
	}
	
	public double costo_servicio(double comision, boolean urgente) {
		double costo;
		
		costo= this.presupuesto + this.materiales + this.trasporte + comision;
		
		if(urgente) {
			costo *=1.5;
		}
		
		return costo;
	}
	
}
