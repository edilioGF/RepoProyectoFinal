package logico;

import java.util.ArrayList;

public class Empresa {
	private String nombre;
	private String ubicacion;
	private String tipo;
	private ArrayList<Empleo> misEmpleos;
	
	public Empresa(String nombre, String ubicacion, String tipo) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.tipo = tipo;
		this.misEmpleos = new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ArrayList<Empleo> getMisEmpleos() {
		return misEmpleos;
	}

	public void setMisEmpleos(ArrayList<Empleo> misEmpleos) {
		this.misEmpleos = misEmpleos;
	}


}
