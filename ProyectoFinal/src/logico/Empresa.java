package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable {
	private String rnc;
	private String nombre;
	private String ubicacion;
	private String tipo;
	private ArrayList<Empleo> misEmpleos;

	public Empresa(String rnc, String nombre, String ubicacion, String tipo) {
		super();
		this.rnc = rnc;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.tipo = tipo;
		this.misEmpleos = new ArrayList<>();
	}

	public String getRnc() {
		return rnc;
	}

	public void setRnc(String rnc) {
		this.rnc = rnc;
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
