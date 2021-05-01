package Ejercicio1;

import java.time.LocalDate;

public abstract class Servicio implements Contratable{

	protected String oficio;
	protected String tipoServicio;
	protected LocalDate fecha_inicio;
	protected boolean urgente;
	
	public String getOficio() {
		return this.oficio;
	}
	
	public LocalDate getFecha() {
		return this.fecha_inicio;
	}
	
	public boolean esUrgente() {
		return this.urgente;
	}
}
