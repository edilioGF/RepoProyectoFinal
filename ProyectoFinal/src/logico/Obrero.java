package logico;

import java.util.ArrayList;

public class Obrero extends Solicitante {
	private ArrayList<String> habilidades;

	public Obrero(String cedula, String nombre, String apellidos, String nacimiento, String genero, String paisOrigen,
			String paisResidencia, boolean trabajo, ArrayList<String> habilidades) {
		super(cedula, nombre, apellidos, nacimiento, genero, paisOrigen, paisResidencia, trabajo);
		this.habilidades = habilidades;
	}

	public ArrayList<String> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(ArrayList<String> habilidades) {
		this.habilidades = habilidades;
	}
}
