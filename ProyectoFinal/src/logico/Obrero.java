package logico;

import java.util.ArrayList;
  
public class Obrero extends Perfil {
	private String habilidad;
	
	public Obrero(Solicitante solicitante, String idioma, boolean licencia, boolean mudarse, int experiencia, String habilidad) {
		super(solicitante, idioma, licencia, mudarse, experiencia);
		this.habilidad = habilidad;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

}
