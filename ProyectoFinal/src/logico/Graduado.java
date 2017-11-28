package logico;

import java.util.ArrayList;

public class Graduado extends Solicitud {
	private String areaEstudio;
	
	public Graduado(Solicitante solicitante, String idioma, boolean licencia, boolean mudarse, int experiencia, String areaEstudio) {
		super(solicitante, idioma, licencia, mudarse, experiencia);
		this.areaEstudio = areaEstudio;
		// TODO Auto-generated constructor stub
	}


	public String getAreaEstudio() {
		return areaEstudio;
	}

	public void setAreaEstudio(String areaEstudio) {
		this.areaEstudio = areaEstudio;
	}
}
