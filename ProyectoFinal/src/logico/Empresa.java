package logico;

import java.util.ArrayList;

public class Empresa {
	private String codigo;
	private String nombre;
	private String ubicacion;
	private String tipo;
	private ArrayList<Empleo> misEmpleos;

	public Empresa(String codigo, String nombre, String ubicacion, String tipo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.tipo = tipo;
		this.misEmpleos = new ArrayList<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
