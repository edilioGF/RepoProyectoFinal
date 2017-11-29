package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Solicitante implements Serializable {
	protected String cedula;
	protected String nombre;
	protected String apellidos;
	protected String nacimiento;
	protected String genero;
	protected String paisOrigen;
	protected String paisResidencia;
	protected boolean trabajo;
	protected ArrayList<Perfil> misPerfiles;

	public Solicitante(String cedula, String nombre, String apellidos, String nacimiento, String genero,
			String paisOrigen, String paisResidencia) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nacimiento = nacimiento;
		this.genero = genero;
		this.paisOrigen = paisOrigen;
		this.paisResidencia = paisResidencia;
		this.trabajo = true;
		this.misPerfiles = new ArrayList<>();
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public String getPaisResidencia() {
		return paisResidencia;
	}

	public void setPaisResidencia(String paisResidencia) {
		this.paisResidencia = paisResidencia;
	}

	public boolean isTrabajo() {
		return trabajo;
	}

	public void setTrabajo(boolean trabajo) {
		this.trabajo = trabajo;
	}

	public ArrayList<Perfil> getMisPerfiles() {
		return misPerfiles;
	}

	public void setMisPerfiles(ArrayList<Perfil> misPerfiles) {
		this.misPerfiles = misPerfiles;
	}

}
