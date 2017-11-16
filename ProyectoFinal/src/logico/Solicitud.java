package logico;

import java.util.ArrayList;
import java.util.Date;

public class Solicitud {
	private String codigo;
	private String fecha;
	private Solicitante solicitante;
	private String idioma;
	private boolean licencia;
	private boolean mudarse;
	private int experiencia;
	private boolean activa;
	private boolean satisfecha;

	public Solicitud(String codigo, Solicitante solicitante, String idioma, boolean licencia, boolean mudarse,
			int experiencia, boolean activa, boolean satisfecha) {
		super();
		this.codigo = codigo;
		this.fecha = (new Date()).toString();
		this.solicitante = solicitante;
		this.idioma = idioma;
		this.licencia = licencia;
		this.mudarse = mudarse;
		this.experiencia = experiencia;
		this.activa = activa;
		this.satisfecha = satisfecha;
	}

	public boolean isSatisfecha() {
		return satisfecha;
	}

	public void setSatisfecha(boolean satisfecha) {
		this.satisfecha = satisfecha;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public boolean isLicencia() {
		return licencia;
	}

	public void setLicencia(boolean licencia) {
		this.licencia = licencia;
	}

	public boolean isMudarse() {
		return mudarse;
	}

	public void setMudarse(boolean mudarse) {
		this.mudarse = mudarse;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

}
