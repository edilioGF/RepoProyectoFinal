package logico;

import java.util.ArrayList;

public class Empleo {
	private String codigo;
	private String titulo;
	private String fecha;
	private int vacantes;
	private String cargo;
	private float salario;
	private int horaInicial;
	private int horaFinal;
	private boolean satisfecho;
	private ArrayList<Solicitud> misSolicitudes;
	private ArrayList<String> idiomas;
	private int experiencia;
	private boolean remoto;
	private boolean licencia;
	private String profesion;

	public Empleo(String codigo, String titulo, String fecha, int vacantes, String cargo, float salario,
			int horaInicial, int horaFinal, boolean satisfecho, ArrayList<Solicitud> misSolicitudes,
			ArrayList<String> idiomas, int experiencia, boolean remoto, boolean licencia, String profesion) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.fecha = fecha;
		this.vacantes = vacantes;
		this.cargo = cargo;
		this.salario = salario;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.satisfecho = satisfecho;
		this.misSolicitudes = misSolicitudes;
		this.idiomas = idiomas;
		this.experiencia = experiencia;
		this.remoto = remoto;
		this.licencia = licencia;
		this.profesion = profesion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getVacantes() {
		return vacantes;
	}

	public void setVacantes(int vacantes) {
		this.vacantes = vacantes;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public int getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(int horaInicial) {
		this.horaInicial = horaInicial;
	}

	public int getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(int horaFinal) {
		this.horaFinal = horaFinal;
	}

	public boolean isSatisfecho() {
		return satisfecho;
	}

	public void setSatisfecho(boolean satisfecho) {
		this.satisfecho = satisfecho;
	}

	public ArrayList<Solicitud> getMisSolicitudes() {
		return misSolicitudes;
	}

	public void setMisSolicitudes(ArrayList<Solicitud> misSolicitudes) {
		this.misSolicitudes = misSolicitudes;
	}

	public ArrayList<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
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

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
}
