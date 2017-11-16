package logico;

import java.util.ArrayList;

public class Obrero extends Solicitante {
	private String habilidad;

	public Obrero(String cedula, String nombre, String apellidos, String nacimiento, String genero, String paisOrigen,
			String paisResidencia, boolean trabajo, String habilidad) {
		super(cedula, nombre, apellidos, nacimiento, genero, paisOrigen, paisResidencia, trabajo);
		this.habilidad = habilidad;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

}
