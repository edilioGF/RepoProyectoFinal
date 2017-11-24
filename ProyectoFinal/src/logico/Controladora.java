package logico;

import java.util.ArrayList;

public class Controladora {
	private ArrayList<Solicitante> misSolicitantes;
	private ArrayList<Empresa> misEmpresas;
	private ArrayList<Solicitud> misSolicitudes;
	private ArrayList<Empleo> misEmpleos;
	private static Controladora controladora;

	public Controladora() {
		super();
		this.misSolicitantes = new ArrayList<>();
		this.misEmpresas = new ArrayList<>();
		this.misSolicitudes = new ArrayList<>();
		this.misEmpleos = new ArrayList<>();
	}
	
	public static Controladora getInstance(){
		if(controladora == null){
			controladora = new Controladora();
		}
		return controladora;
	}

	// Se busca empresa por empresa
	// Se obtienen las ofertas / empleos
	// Se obtienen las solicitudes
	// Se comparan
	// Se marca el solicitante como trabajo = true, solicitud como satisfecha e
	// inactiva y se marcan
	// las otras solicitudes de ese solicitante como inactivas

	public void match() {
		for (Empleo empleo : misEmpleos) {
			for (Solicitud solicitud : empleo.getMisSolicitudes()) {
				if (empleo.getVacantes() > 0 && solicitud.isActiva()) {
					if (empleo.getExperiencia() <= solicitud.getExperiencia()) {
						if ((empleo.isRemoto() && solicitud.isMudarse()) || !empleo.isRemoto()) {
							if (empleo.isLicencia() && solicitud.isLicencia() || !empleo.isLicencia()) {
								if (empleo.isGraduado() && solicitud.getSolicitante() instanceof Graduado) {
									if (empleo.getArea().equalsIgnoreCase(
											((Graduado) solicitud.getSolicitante()).getAreaEstudio())) {
										evaluarSolicitud(solicitud, empleo);
									}
								} else if (empleo.isTecnico() && solicitud.getSolicitante() instanceof Tecnico) {

									if (empleo.getTitulo()
											.equalsIgnoreCase(((Tecnico) solicitud.getSolicitante()).getTitulo())) {
										evaluarSolicitud(solicitud, empleo);
									}
								} else {
									if (empleo.getHabilidad()
											.equalsIgnoreCase(((Obrero) solicitud.getSolicitante()).getHabilidad())) {
										evaluarSolicitud(solicitud, empleo);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private void evaluarSolicitud(Solicitud solicitud, Empleo empleo) {
		solicitud.getSolicitante().setTrabajo(true);
		solicitud.setSatisfecha(true);
		empleo.setSatisfecho(true);
		empleo.setVacantes(empleo.getVacantes() - 1);
		empleo.setEmpleado(solicitud.getSolicitante());
		empleo.inactivarSolicitudes();
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

	public Solicitante buscarSolicitante(String cedula) {
		Solicitante solicitante = null;
		boolean find = false;
		int i = 0;
		while (!find && i < misSolicitantes.size()) {
			if (misSolicitantes.get(i).getCedula().equalsIgnoreCase(cedula)) {
				solicitante = misSolicitantes.get(i);
				find = true;
			}
			i++;
		}
		return solicitante;
	}

	public Empresa buscarEmpresa(String codigo) {
		Empresa empresa = null;
		boolean find = false;
		int i = 0;
		while (!find && i < misEmpresas.size()) {
			if (misEmpresas.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				empresa = misEmpresas.get(i);
				find = true;
			}
			i++;
		}
		return empresa;
	}

	public Solicitud buscarSolicitud(String codigo) {
		Solicitud solicitud = null;
		boolean find = false;
		int i = 0;
		while (!find && i < misSolicitudes.size()) {
			if (misSolicitudes.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				solicitud = misSolicitudes.get(i);
				find = true;
			}
			i++;
		}
		return solicitud;
	}

	public Empleo buscarEmpleo(String codigo) {
		Empleo empleo = null;
		boolean find = false;
		int i = 0;
		while (!find && i < misEmpleos.size()) {
			if (misEmpleos.get(i).getCodigo().equalsIgnoreCase(codigo)) {
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
