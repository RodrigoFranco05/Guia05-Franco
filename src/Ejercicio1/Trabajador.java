package Ejercicio1;

import Exepciones.*;
import java.util.ArrayList;

public class Trabajador {
	private String nombre;
	private String correo;
	private String oficio;
	private double costo_hora;
	private float comision;
	private ArrayList<Trabajo> trabajo;
	
	
	public Trabajador (String nombre, String correo, String oficio, double costo_hora) {
		this.nombre = nombre;
		this.correo = correo;
		this.oficio = oficio;
		this.costo_hora = costo_hora;
		
		this.trabajo=new ArrayList<>(1);
		
	}
	
	public void asignartrabajo(Servicio servicio) throws AgendaOcupadaException,OficioNoCoincideException{
		if(servicio instanceof ServicioEstandar) {
			boolean ocupado=false;
			for (Trabajo unTrabajo : trabajo) {
				if(unTrabajo.getFechaServicio().compareTo(servicio.fecha_inicio)==0) {
					ocupado=true;
				}
			}
			if(ocupado) {
				throw new AgendaOcupadaException();
			}
			if(this.oficio != servicio.getOficio()) {
				throw new OficioNoCoincideException();
			}
			
			trabajo.add(new Trabajo(servicio,servicio.getFecha()));
			
			}
			else if(servicio instanceof ServicioPersonalizado) {
				boolean ocupado=false;
				for (Trabajo unTrabajo : trabajo) {
					if(unTrabajo.getFechaServicio().compareTo(servicio.fecha_inicio)==0) {
						ocupado=true;
					}
				}
				if(ocupado) {
					throw new AgendaOcupadaException();
				}
				if(this.oficio != servicio.getOficio()) {
					throw new OficioNoCoincideException();
				}
				
				trabajo.add(new Trabajo(servicio,servicio.getFecha()));
			
				}
	}

	public double getCosto_hora() {
		return costo_hora;
	}

	
	public double calcular_costo(Servicio servicio) {
		double c=0;
		if(servicio instanceof ServicioEstandar) {
		c=calcular_costo2(servicio);;
		
	}
		else if(servicio instanceof ServicioPersonalizado) {
		c=calcular_costo3(servicio);
	}
		return c;
	}
	
	
	public double calcular_costo2(Servicio servicio) {
		double costo;
		double costTrabajador=0;
		
			for (Trabajo unTrabajo : this.trabajo) {
				if (unTrabajo.getServicio()==servicio) {
					costTrabajador= unTrabajo.costoTrabajador();
					}
				}
			costo= (((ServicioEstandar)servicio).costo_servicio(costTrabajador,servicio.urgente));
			return costo;
	}
	
	public double calcular_costo3(Servicio servicio) {
		double costo;
		double costTrabajador=0;
		for (Trabajo unTrabajo : this.trabajo) {
			if (unTrabajo.getServicio()==servicio) {
				costTrabajador= unTrabajo.costoTrabajador();
			}
		}
		
		costo=((ServicioPersonalizado)servicio).costo_servicio(costTrabajador,servicio.urgente);
		return costo;	
		
	}
	
	public void finalizado(Servicio servicio) {

		for (Trabajo unTrabajo : this.trabajo) {
			if (unTrabajo.getServicio()==servicio) {
				unTrabajo.finalizar();
				return;
			}
		}
		
		
	}
}



