package logico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.security.KeyStore.LoadStoreParameter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import javax.swing.JOptionPane;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import visual.Principal;

public class Controladora {
	private ArrayList<Solicitante> misSolicitantes;
	private ArrayList<Empresa> misEmpresas;
	private ArrayList<Perfil> misPerfiles;
	private ArrayList<Perfil> misPerfiles2;
	private ArrayList<Empleo> misEmpleos;

	private static String[] misTiposDeEmpresa = { "Turismo", "Salud", "Eduación", "Software", "Alimentación", "Público",
			"Privado", "Infra-Estructura", "Negocio", "Hidroelectrica" };
	private static String[] misAreasDeEstudio = { "Administración de Empresa", "Administración Hotelera", "Economía",
			"Gestión Financiera", "Mercadotecnia", "Arquitectura", "Derecho", "Educación", "Psicología",
			"Ingeniería Civil", "Electromecánica", "Electrónica", "Industrial", "Mecatrónica", "Sistemas y Computación",
			"Telemática", "Enfermería", "Estomatología", "Medicina", "Filosofía" };

	private static String[] misTitulos = { "Contabilidad", "Informática", "Mecánica Industrial", "Electrónica",
			"Electricidad", "Diseño Gráfico", "Telecomunicaciones" };
	private static String[] misHabilidades = { "Albañilería", "Carpintería", "Ebanistería", "Herrería", "Mecánica",
			"Plomería", "Confeccionista", "Pintura", "Tapicería" };
	private static String[] misFormaciones = { "Graduado", "Técnico", "Obrero" };
	private static String[] misGeneros = { "Masculino", "Femenino" };

	private static Controladora controladora;

	public Controladora() {
		super();
		this.misSolicitantes = new ArrayList<>();
		this.misEmpresas = new ArrayList<>();
		this.misPerfiles = new ArrayList<>();
		this.misEmpleos = new ArrayList<>();
		this.misPerfiles2 = new ArrayList<>();
	}

	public static Controladora getInstance() {
		if (controladora == null) {
			controladora = new Controladora();
		}
		return controladora;
	}

	public void ordenarPerfiles() {
		int i, j, mayor, pos;
		Perfil tmp;
		// misPerfiles2 = misPerfiles;

		misPerfiles2.clear();

		for (Perfil perfil : misPerfiles) {
			misPerfiles2.add(perfil);
		}

		for (i = 0; i < misPerfiles2.size() - 1; i++) {
			mayor = misPerfiles2.get(i).getExperiencia();
			pos = i;

			for (j = i + 1; j < misPerfiles2.size(); j++) {
				if (misPerfiles2.get(j).getExperiencia() > mayor) {
					mayor = misPerfiles2.get(j).getExperiencia();
					pos = j;
				}
			}
			if (pos != i) {
				tmp = misPerfiles2.get(i);
				misPerfiles2.set(i, misPerfiles2.get(pos));
				misPerfiles2.set(pos, tmp);
			}
		}
	}

	public boolean verificarEmpleos() {
		boolean res = false;
		int i = 0;

		while (i < misEmpleos.size() && !res) {
			if (!misEmpleos.get(i).isSatisfecho()) {
				res = true;
			}

			i++;
		}

		return res;
	}

	public boolean verificarPerfiles() {
		boolean res = false;
		int i = 0;

		while (i < misPerfiles.size() && !res) {
			if (!misPerfiles.get(i).getSolicitante().isTrabajo()) {
				res = true;
			}

			i++;
		}

		return res;
	}

	public void retirarSolicitante(Solicitante solicitante) {
		Empleo empleo = null;
		boolean find = false;
		int i = 0;
		int j = 0;
		while (!find && i < misEmpleos.size()) {
			while (!find && j < misEmpleos.get(i).getEmpleados().size()) {
				if (misEmpleos.get(i).getEmpleados().get(j) == solicitante) {
					empleo = misEmpleos.get(i);
					find = true;
				}
				j++;
			}
			j = 0;
			i++;
		}
		empleo.getEmpleados().remove(solicitante);
		empleo.setVacantes(empleo.getVacantes() + 1);
		eliminarPerfil(solicitante);
	}

	public void eliminarPerfil(Solicitante solicitante) {
		int i = 0;
		boolean find = false;

		while (!find && i < solicitante.getMisPerfiles().size()) {
			if (solicitante.getMisPerfiles().get(i).isSatisfecha()) {
				find = true;
				solicitante.getMisPerfiles().remove(i);
			}
			i++;
		}
	}

	public void eliminarSolicitante(Solicitante solicitante) {
		for (Perfil perfil : solicitante.getMisPerfiles()) {
			misPerfiles.remove(perfil);
		}
		misSolicitantes.remove(solicitante);
	}

	public void match() throws IOException {
		if (verificarEmpleos() && verificarPerfiles()) {
			ordenarPerfiles();

			Date date = new Date();
			String str = new SimpleDateFormat("dd_MM_yyyy_hh_mm").format(date);
			String str2 = new SimpleDateFormat("dd/MM/yyyy hh:mm").format(date);
			BufferedWriter writer = new BufferedWriter(new FileWriter("Match_" + str + ".txt"));

			writer.write("Fecha: " + str2);
			writer.newLine();
			writer.newLine();
			writer.write("Datos del matcheo:");
			writer.newLine();
			writer.newLine();

			int cont = 0;

			for (Empleo empleo : misEmpleos) {
				if (empleo.getVacantes() > 0) {
					// Perfiles organizados...
					for (Perfil perfil : misPerfiles2) {
						if (!perfil.getSolicitante().isTrabajo()) {
							// Condiciones...
							// #1 Experiencia
							if (empleo.getExperiencia() <= perfil.getExperiencia()) {
								// #2 Está dispuesto a mudarse?
								if ((perfil.isMudarse() && empleo.isRemoto()) || (!empleo.isRemoto())) {
									// #3 Tiene licencia?
									if ((perfil.isLicencia() && empleo.isLicencia()) || (!empleo.isLicencia())) {
										// #4 Idioma (?)
										if (perfil.getIdioma().equalsIgnoreCase(empleo.getIdioma())) {
											// #5 Formación...
											if (empleo.isGraduado() && perfil instanceof Graduado) {
												if (empleo.getArea()
														.equalsIgnoreCase(((Graduado) perfil).getAreaEstudio())) {
													actualizarMatch(empleo, perfil);
													cont++;
													escribirMatch(writer, perfil, empleo);
												}
											} else if (empleo.isTecnico() && perfil instanceof Tecnico) {
												if (empleo.getTituloTecnico()
														.equalsIgnoreCase(((Tecnico) perfil).getTitulo())) {
													cont++;
													actualizarMatch(empleo, perfil);
													escribirMatch(writer, perfil, empleo);
												}
											} else if (empleo.isObrero() && perfil instanceof Obrero) {
												if (empleo.getHabilidad()
														.equalsIgnoreCase(((Obrero) perfil).getHabilidad())) {
													cont++;
													actualizarMatch(empleo, perfil);
													escribirMatch(writer, perfil, empleo);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}

			if (cont == 0) {
				writer.write("No se realizaron matcheos.");
			}

			writer.close();

			JOptionPane.showMessageDialog(null, "Se generó un archivo con los datos de este Matcheo", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void escribirMatch(BufferedWriter writer, Perfil perfil, Empleo empleo) throws IOException {
		// TODO Auto-generated method stub
		perfil.getSolicitante().setTrabajo(true);

		writer.write(perfil.getSolicitante().getCedula() + "-" + perfil.getSolicitante().getNombre() + " "
				+ perfil.getSolicitante().getApellidos() + " ahora trabaja con: " + empleo.getEmpresa().getRnc() + "-"
				+ empleo.getEmpresa().getNombre() + ", en el empleo: " + empleo.getCodigo() + " " + empleo.getTitulo());
		writer.newLine();
		writer.newLine();
	}

	private void actualizarMatch(Empleo empleo, Perfil perfil) {
		empleo.setVacantes(empleo.getVacantes() - 1);
		empleo.getEmpleados().add(perfil.getSolicitante());
		if (empleo.getVacantes() == 0) {
			empleo.setSatisfecho(true);
		}
		perfil.getSolicitante().setTrabajo(true);
		Perfil per = buscarPerfil(perfil.getCodigo());
		per.setSatisfecha(true);
		Solicitante sol = buscarSolicitante(perfil.getSolicitante().getCedula());
		sol.desactivarPerfiles();
		sol.setTrabajo(true);
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
		} else {
			File arch = new File("Solicitantes.dat");
			arch.delete();
		}

		if (misEmpresas.size() > 0) {
			FileOutputStream archEmpresas = new FileOutputStream("Empresas.dat");
			ObjectOutputStream oosEmpresas = new ObjectOutputStream(archEmpresas);
			oosEmpresas.writeInt(misEmpresas.size());
			for (Empresa emp : misEmpresas) {
				oosEmpresas.writeObject(emp);
			}
			archEmpresas.close();
		} else {
			File arch = new File("Empresas.dat");
			arch.delete();
		}

		if (misEmpleos.size() > 0) {
			FileOutputStream archEmpleos = new FileOutputStream("Empleos.dat");
			ObjectOutputStream oosEmpleos = new ObjectOutputStream(archEmpleos);
			oosEmpleos.writeInt(misEmpleos.size());
			for (Empleo empl : misEmpleos) {
				oosEmpleos.writeObject(empl);
			}
			archEmpleos.close();
		} else {
			File arch = new File("Empleos.dat");
			arch.delete();
		}

		if (misPerfiles.size() > 0) {
			FileOutputStream archPerfiles = new FileOutputStream("Perfiles.dat");
			ObjectOutputStream oosPerfiles = new ObjectOutputStream(archPerfiles);
			oosPerfiles.writeInt(misPerfiles.size());
			for (Perfil perfil : misPerfiles) {
				oosPerfiles.writeObject(perfil);
			}
			archPerfiles.close();
		} else {
			File arch = new File("Perfiles.dat");
			arch.delete();
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

	public Perfil buscarPerfil(String codigo) {
		Perfil profile = null;
		boolean find = false;
		int i = 0;
		while (!find && i < misPerfiles.size()) {
			if (misPerfiles.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				profile = misPerfiles.get(i);
				find = true;
			}
			i++;
		}
		return profile;
	}

	public void eliminarPerfilSolicitante(Perfil perfil) {
		ArrayList<Perfil> delete = new ArrayList<>();

		for (Solicitante sol : misSolicitantes) {
			for (Perfil perf : sol.getMisPerfiles()) {
				if (perf.getCodigo().equalsIgnoreCase(perfil.getCodigo())) {
					delete.add(perf);
				}
			}

			if (perfil.getSolicitante().getCedula().equalsIgnoreCase(sol.getCedula())) {
				for (Perfil perfil2 : delete) {
					sol.getMisPerfiles().remove(perfil2);
				}
			}
		}
	}

	public void eliminarEmpleosEmpresa(Empresa empresaList) {
		ArrayList<Empleo> delete = new ArrayList<>();

		for (Empleo empleo : misEmpleos) {
			for (Empleo empl : empresaList.getMisEmpleos()) {
				if (empleo.getCodigo().equalsIgnoreCase(empl.getCodigo())) {
					delete.add(empleo);
				}
			}
		}

		for (Empleo empleo : delete) {
			misEmpleos.remove(empleo);
		}

		Principal.loadStats();
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

	public ArrayList<Perfil> getMisPerfiles2() {
		return misPerfiles2;
	}

	public void setMisPerfiles2(ArrayList<Perfil> misPerfiles2) {
		this.misPerfiles2 = misPerfiles2;
	}
}
