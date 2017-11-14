package logico;

import java.util.ArrayList;

public class Controladora {
	private ArrayList<Solicitante> misSolicitantes;
	private ArrayList<Empresa> misEmpresas;
	private ArrayList<Solicitud> misSolicitudes;
	private ArrayList<Empleo> misEmpleos;
	
	public Controladora() {
		super();
		this.misSolicitantes = new ArrayList<>();
		this.misEmpresas = new ArrayList<>();
		this.misSolicitudes = new ArrayList<>();
		this.misEmpleos = new ArrayList<>();
	}

	public ArrayList<Solicitante> getMisSolicitantes() {
		return misSolicitantes;
	}

	public void setMisSolicitantes(ArrayList<Solicitante> misSolicitantes) {
		this.misSolicitantes = misSolicitantes;
	}

	public ArrayList<Empresa> getMisEmpresas() {
		return misEmpresas;
	}

	public void setMisEmpresas(ArrayList<Empresa> misEmpresas) {
		this.misEmpresas = misEmpresas;
	}

	public ArrayList<Solicitud> getMisSolicitudes() {
		return misSolicitudes;
	}

	public void setMisSolicitudes(ArrayList<Solicitud> misSolicitudes) {
		this.misSolicitudes = misSolicitudes;
	}

	public ArrayList<Empleo> getMisEmpleos() {
		return misEmpleos;
	}

	public void setMisEmpleos(ArrayList<Empleo> misEmpleos) {
		this.misEmpleos = misEmpleos;
	}

}
