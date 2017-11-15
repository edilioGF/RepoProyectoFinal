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

	public void addSolicitante(Solicitante soli) {
		misSolicitantes.add(soli);
	}

	public void addEmpresa(Empresa emp) {
		misEmpresas.add(emp);
	}

	public void addEmpleo(Empleo empl) {
		misEmpleos.add(empl);
	}

	public void addSolicitud(Solicitud sol) {
		misSolicitudes.add(sol);
	}

	public Solicitante buscarSolicitante(String cedula){
		Solicitante solicitante = null;
		boolean find = false;
		int i = 0;
		while(!find && i < misSolicitantes.size()){
			if(misSolicitantes.get(i).getCedula().equalsIgnoreCase(cedula)){
				solicitante = misSolicitantes.get(i);
				find = true;
			}
			i++;
		}
		return solicitante;
	}
	
	public Empresa buscarEmpresa(String codigo){
		Empresa empresa = null;
		boolean find = false;
		int i = 0;
		while(!find && i < misEmpresas.size()){
			if(misEmpresas.get(i).getCodigo().equalsIgnoreCase(codigo)){
				empresa = misEmpresas.get(i);
				find = true;
			}
			i++;
		}
		return empresa;
	}
	
	public Solicitud buscarSolicitud(String codigo){
		Solicitud solicitud = null;
		boolean find = false;
		int i = 0;
		while(!find && i < misSolicitudes.size()){
			if(misSolicitudes.get(i).getCodigo().equalsIgnoreCase(codigo)){
				solicitud = misSolicitudes.get(i);
				find = true;
			}
			i++;
		}
		return solicitud;
	}
	
	public Empleo buscarEmpleo(String codigo){
		Empleo empleo = null;
		boolean find = false;
		int i = 0;
		while(!find && i < misEmpleos.size()){
			if(misEmpleos.get(i).getCodigo().equalsIgnoreCase(codigo)){
				empleo = misEmpleos.get(i);
				find = true;
			}
			i++;
		}
		return empleo;
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
