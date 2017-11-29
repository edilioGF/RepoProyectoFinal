package logico;

import java.util.ArrayList;

public class Graduado extends Perfil {
	private String areaEstudio;
	
	public Graduado(String codigo , Solicitante solicitante, String idioma, boolean licencia, boolean mudarse, int experiencia, String areaEstudio) {
		super(codigo ,solicitante, idioma, licencia, mudarse, experiencia);
		this.areaEstudio = areaEstudio;
	}

	public String getAreaEstudio() {
		return areaEstudio;
	}

	public void setAreaEstudio(String areaEstudio) {
		this.areaEstudio = areaEstudio;
	}
}
