package logico;

import java.util.ArrayList;

public class Solicitud {

	private String codigo;
	private String fecha;
	private Solicitante solicitante;
	private ArrayList<String> idiomas;
	private boolean remoto;
	private boolean licencia;
	private boolean mudarse;
	private int experiencia;
	private boolean activa;

	public Solicitud(String codigo, String fecha, Solicitante solicitante, ArrayList<String> idiomas, boolean remoto,
			boolean licencia, boolean mudarse, int experiencia, boolean activa) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.solicitante = solicitante;
		this.idiomas = idiomas;
		this.remoto = remoto;
		this.licencia = licencia;
		this.mudarse = mudarse;
		this.experiencia = experiencia;
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

	public ArrayList<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
	}

	public boolean isRemoto() {
		return remoto;
	}

	public void setRemoto(boolean remoto) {
		this.remoto = remoto;
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
