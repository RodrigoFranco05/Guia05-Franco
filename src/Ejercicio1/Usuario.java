package Ejercicio1;

import Exepciones.*;
import java.util.ArrayList;

public class Usuario {
	private ArrayList<Contratable> contratos;
	private String nombre;
	private String mail;
	
	public Usuario(String nombre,String mail) {
		this.nombre=nombre;
		this.mail=mail;
		this.contratos=new ArrayList<>(1);
		
	}

	public void contratar(Contratable c) throws AlquilerNoEntregadoException {
		if(c instanceof Servicio) {
			this.contratos.add(c);
		}
		else if(c instanceof Alquiler) {
			int t= alquilernoentregado(this.contratos);
			if(t<3) {
			this.contratos.add(c);
			}
			else {
				throw new AlquilerNoEntregadoException();
			}
		}
	}
	
	public int alquilernoentregado(ArrayList<Contratable> contratos) {
		int t=0;
		for(Contratable Cont: this.contratos) {
			if(Cont instanceof Alquiler && !((Alquiler) Cont).finalizado()) {
				t++;
				}
		}
		return t;
	}
	
	
	public void devolver(Alquiler alq) {
		alq.devolver();
		this.contratos.remove(alq);
		alq.alquiler();
	}
}
