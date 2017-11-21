package logico;

import java.util.ArrayList;

public class Obrero extends Solicitante {
	private String habilidad;

	public Obrero(String cedula, String nombre, String apellidos, String nacimiento, String genero, String paisOrigen,
			String paisResidencia, String habilidad) {
		super(cedula, nombre, apellidos, nacimiento, genero, paisOrigen, paisResidencia);
		this.habilidad = habilidad;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

}
