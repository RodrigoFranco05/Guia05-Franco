package Ejercicio1;

public class Herramienta {

	private String nombre;
	private double costo_dia;

	
	public Herramienta (String nombre, double costo_dia) {
		this.nombre = nombre;
		this.costo_dia = costo_dia;
	}

	public double getCostodia() {
		return costo_dia;
	}
}
