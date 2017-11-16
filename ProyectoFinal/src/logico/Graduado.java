package logico;

import java.util.ArrayList;

public class Graduado extends Solicitante {
	private String areaEstudio;

	public Graduado(String cedula, String nombre, String apellidos, String nacimiento, String genero, String paisOrigen,
			String paisResidencia, boolean trabajo, String areaEstudio) {
		super(cedula, nombre, apellidos, nacimiento, genero, paisOrigen, paisResidencia, trabajo);
		this.areaEstudio = areaEstudio;
	}

	public String getAreaEstudio() {
		return areaEstudio;
	}

	public void setAreaEstudio(String areaEstudio) {
		this.areaEstudio = areaEstudio;
	}
}
