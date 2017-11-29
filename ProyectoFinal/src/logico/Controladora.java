package logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Controladora {
	private ArrayList<Solicitante> misSolicitantes;
	private ArrayList<Empresa> misEmpresas;
	private ArrayList<Perfil> misPerfiles;
	private ArrayList<Empleo> misEmpleos;

	private static String[] misTiposDeEmpresa = { "Turismo", "Salud", "Eduaci�n", "Software", "Alimentaci�n", "P�blico",
			"Privado", "Infra-Estructura", "Negocio", "Hidroelectrica" };
	private static String[] misAreasDeEstudio = { "Administraci�n de Empresa", "Administraci�n Hotelera", "Econom�a",
			"Gesti�n Financiera", "Mercadotecnia", "Arquitectura", "Derecho", "Educaci�n", "Psicolog�a",
			"Ingenier�a Civil", "Electromec�nica", "Electr�nica", "Industrial", "Mecatr�nica", "Sistemas y Computaci�n",
			"Telem�tica", "Enfermer�a", "Estomatolog�a", "Medicina", "Filosof�a" };

	private static String[] misTitulos = { "Contabilidad", "Inform�tica", "Mec�nica Industrial", "Electr�nica",
			"Electricidad", "Dise�o Gr�fico", "Telecomunicaciones" };
	private static String[] misHabilidades = { "Alba�iler�a", "Carpinter�a", "Ebanister�a", "Herrer�a", "Mec�nica",
			"Plomer�a", "Confeccionista", "Pintura", "Tapicer�a" };
	private static String[] misFormaciones = { "Graduado", "T�cnico", "Obrero" };
	private static String[] misGeneros = {"Masculino" , "Femenino"};

	private static Controladora controladora;

	public Controladora() {
		super();
		this.misSolicitantes = new ArrayList<>();
		this.misEmpresas = new ArrayList<>();
		this.misPerfiles = new ArrayList<>();
		this.misEmpleos = new ArrayList<>();
	}

	public static Controladora getInstance() {
		if (controladora == null) {
			controladora = new Controladora();
		}
		return controladora;
	}

	public void saveData() throws IOException {

		if (misSolicitantes.size() > 0) {
			FileOutputStream archSolicitantes = new FileOutputStream("Solicitantes.dat");
			ObjectOutputStream oosSolicitantes = new ObjectOutputStream(archSolicitantes);
			oosSolicitantes.writeInt(misSolicitantes.size());
			for (Solicitante soli : misSolicitantes) {
				oosSolicitantes.writeObject(soli);
			}
			archSolicitantes.close();
		}

		if (misEmpresas.size() > 0) {
			FileOutputStream archEmpresas = new FileOutputStream("Empresas.dat");
			ObjectOutputStream oosEmpresas = new ObjectOutputStream(archEmpresas);
			oosEmpresas.writeInt(misEmpresas.size());
			for (Empresa emp : misEmpresas) {
				oosEmpresas.writeObject(emp);
			}
			archEmpresas.close();
		}

		if (misEmpleos.size() > 0) {
			FileOutputStream archEmpleos = new FileOutputStream("Empleos.dat");
			ObjectOutputStream oosEmpleos = new ObjectOutputStream(archEmpleos);
			oosEmpleos.writeInt(misEmpleos.size());
			for (Empleo empl : misEmpleos) {
				oosEmpleos.writeObject(empl);
			}
			archEmpleos.close();
		}

		if (misPerfiles.size() > 0) {
			FileOutputStream archPerfiles = new FileOutputStream("Perfiles.dat");
			ObjectOutputStream oosPerfiles = new ObjectOutputStream(archPerfiles);
			oosPerfiles.writeInt(misPerfiles.size());
			for (Perfil perfil : misPerfiles) {
				oosPerfiles.writeObject(perfil);
			}
			archPerfiles.close();
		}
	}

	public void loadData() throws IOException, ClassNotFoundException {

		File soli = new File("Solicitantes.dat");
		File empr = new File("Empresas.dat");
		File empl = new File("Empleos.dat");
		File perf = new File("Perfiles.dat");

		if (soli.exists()) {
			FileInputStream archSolicitantes = new FileInputStream("Solicitantes.dat");
			ObjectInputStream oisSolicitantes = new ObjectInputStream(archSolicitantes);
			int sizeSolicitantes = oisSolicitantes.readInt();
			for (int i = 0; i < sizeSolicitantes; i++) {
				misSolicitantes.add((Solicitante) oisSolicitantes.readObject());
			}
			archSolicitantes.close();
		}

		if (empr.exists()) {
			FileInputStream archEmpresas = new FileInputStream("Empresas.dat");
			ObjectInputStream oisEmpresas = new ObjectInputStream(archEmpresas);
			int sizeEmpresas = oisEmpresas.readInt();
			for (int i = 0; i < sizeEmpresas; i++) {
				misEmpresas.add((Empresa) oisEmpresas.readObject());
			}
			archEmpresas.close();
		}
		if (empl.exists()) {
			FileInputStream archEmpleos = new FileInputStream("Empleos.dat");
			ObjectInputStream oisEmpleos = new ObjectInputStream(archEmpleos);
			int sizeEmpleos = oisEmpleos.readInt();
			for (int i = 0; i < sizeEmpleos; i++) {
				misEmpleos.add((Empleo) oisEmpleos.readObject());
			}
			archEmpleos.close();

		}
		if (perf.exists()) {
			FileInputStream archPerfiles = new FileInputStream("Perfiles.dat");
			ObjectInputStream oisPerfiles = new ObjectInputStream(archPerfiles);
			int sizePerfiles = oisPerfiles.readInt();

			for (int i = 0; i < sizePerfiles; i++) {
				misPerfiles.add((Perfil) oisPerfiles.readObject());
			}
			archPerfiles.close();
		}
	}

	// Se busca empresa por empresa
	// Se obtienen las ofertas / empleos
	// Se obtienen las solicitudes
	// Se comparan
	// Se marca el solicitante como trabajo = true, solicitud como satisfecha e
	// inactiva y se marcan
	// las otras solicitudes de ese solicitante como inactivas

	/*
	 * public void match() { for (Empleo empleo : misEmpleos) { for (Solicitud
	 * solicitud : empleo.getMisSolicitudes()) { if (empleo.getVacantes() > 0 &&
	 * solicitud.isActiva()) { if (empleo.getExperiencia() <=
	 * solicitud.getExperiencia()) { if ((empleo.isRemoto() &&
	 * solicitud.isMudarse()) || !empleo.isRemoto()) { if (empleo.isLicencia()
	 * && solicitud.isLicencia() || !empleo.isLicencia()) { if
	 * (empleo.isGraduado() && solicitud.getSolicitante() instanceof Graduado) {
	 * if (empleo.getArea().equalsIgnoreCase( ((Graduado)
	 * solicitud.getSolicitante()).getAreaEstudio())) {
	 * evaluarSolicitud(solicitud, empleo); } } else if (empleo.isTecnico() &&
	 * solicitud.getSolicitante() instanceof Tecnico) {
	 * 
	 * if (empleo.getTitulo() .equalsIgnoreCase(((Tecnico)
	 * solicitud.getSolicitante()).getTitulo())) { evaluarSolicitud(solicitud,
	 * empleo); } } else { if (empleo.getHabilidad() .equalsIgnoreCase(((Obrero)
	 * solicitud.getSolicitante()).getHabilidad())) {
	 * evaluarSolicitud(solicitud, empleo); } } } } } } } } }
	 */

	/*
	 * private void evaluarSolicitud(Perfil , Empleo empleo) {
	 * solicitud.getSolicitante().setTrabajo(true);
	 * solicitud.setSatisfecha(true); empleo.setSatisfecho(true);
	 * empleo.setVacantes(empleo.getVacantes() - 1);
	 * empleo.setEmpleado(solicitud.getSolicitante()); //
	 * empleo.inactivarSolicitudes(); }
	 */

	public void addSolicitante(Solicitante soli) {
		misSolicitantes.add(soli);
	}

	public void addEmpresa(Empresa emp) {
		misEmpresas.add(emp);
	}

	public void addEmpleo(Empleo empl) {
		misEmpleos.add(empl);
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
			if (misEmpresas.get(i).getRnc().equalsIgnoreCase(codigo)) {
				empresa = misEmpresas.get(i);
				find = true;
			}
			i++;
		}
		return empresa;
	}

	public int[] contarHombresMujeres() {
		// 0 -> Mujeres // 1 -> Hombres
		int arr[] = { 0, 0 };

		for (Solicitante sol : misSolicitantes) {
			if (sol.getGenero().equalsIgnoreCase("femenino")) {
				arr[0]++;
			} else {
				arr[1]++;
			}
		}
		return arr;
	}

	public int[] contarOferta() {
		int arr[] = { 0, 0, 0 };

		for (Perfil perfil : misPerfiles) {
			if (perfil instanceof Graduado) {
				arr[0]++;
			} else if (perfil instanceof Tecnico) {
				arr[1]++;
			} else {
				arr[2]++;
			}
		}

		return arr;
	}

	public int[] contarDemanda() {
		int arr[] = { 0, 0, 0 };

		for (Empleo emp : misEmpleos) {
			if (emp.isGraduado()) {
				arr[0]++;
			} else if (emp.isTecnico()) {
				arr[1]++;
			} else {
				arr[2]++;
			}
		}

		return arr;
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

	public ArrayList<Empleo> getMisEmpleos() {
		return misEmpleos;
	}

	public void setMisEmpleos(ArrayList<Empleo> misEmpleos) {
		this.misEmpleos = misEmpleos;
	}

	public static String[] getMisAreasDeEstudio() {
		return misAreasDeEstudio;
	}

	public static void setMisAreasDeEstudio(String[] misAreasDeEstudio) {
		Controladora.misAreasDeEstudio = misAreasDeEstudio;
	}

	public static String[] getMisTitulos() {
		return misTitulos;
	}

	public static void setMisTitulos(String[] misTitulos) {
		Controladora.misTitulos = misTitulos;
	}

	public static String[] getMisHabilidades() {
		return misHabilidades;
	}

	public static void setMisHabilidades(String[] misHabilidades) {
		Controladora.misHabilidades = misHabilidades;
	}

	public static String[] getMisTiposDeEmpresa() {
		return misTiposDeEmpresa;
	}

	public static void setMisTiposDeEmpresa(String[] misTiposDeEmpresa) {
		Controladora.misTiposDeEmpresa = misTiposDeEmpresa;
	}

	public static String[] getMisFormaciones() {
		return misFormaciones;
	}

	public static void setMisFormaciones(String[] misFormaciones) {
		Controladora.misFormaciones = misFormaciones;
	}

	public ArrayList<Perfil> getMisPerfiles() {
		return misPerfiles;
	}

	public void setMisPerfiles(ArrayList<Perfil> misPerfiles) {
		this.misPerfiles = misPerfiles;
	}

	public static String[] getMisGeneros() {
		return misGeneros;
	}

	public static void setMisGeneros(String[] misGeneros) {
		Controladora.misGeneros = misGeneros;
	}
}
