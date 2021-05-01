package Ejercicio1;

import java.time.LocalDate;

public class ServicioEstandar extends Servicio {
	private double monto_fijo;
	
	public ServicioEstandar(String oficio,String tipoServicio,LocalDate fecha_inicio,double monto_fijo) {
		this.monto_fijo=monto_fijo;
		this.tipoServicio = tipoServicio;
		this.oficio=oficio;
		this.fecha_inicio=fecha_inicio;
	}
	
	public double costo_servicio(double comision, boolean urgente) {
		double costo;
		
		costo= this.monto_fijo + comision;
		
		if(urgente) {
			costo *=1.5;
		}
		
		return costo;
	}
	
	
}
