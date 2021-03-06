package logico;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Empleo implements Serializable {
	private String codigo;
	private String titulo;
	private String fecha;
	private int vacantes;
	private String descripcion;
	private float salario;
	private int horaInicial;
	private int horaFinal;
	private boolean satisfecho;
	private String idioma;
	private int experiencia;
	private boolean remoto;
	private boolean licencia;

	private boolean graduado;
	private boolean tecnico;
	private boolean obrero;

	private String tituloTecnico;
	private String area;
	private String habilidad;

	private Empresa empresa;

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	private ArrayList<Solicitante>empleados;

	public Empleo(String codigo,String titulo, int vacantes, String descripcion, float salario, int horaInicial, int horaFinal,
			boolean satisfecho, String idioma, int experiencia, boolean remoto, boolean licencia, boolean graduado,
			boolean tecnico, boolean obrero, String tituloTecnico, String area, String habilidad, Empresa empresa) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;

		Date date = new Date();
		String str = new SimpleDateFormat("dd/MM/yyyy").format(date);

		this.fecha = str;

		this.vacantes = vacantes;
		this.descripcion = descripcion;
		this.salario = salario;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.satisfecho = satisfecho;
		this.idioma = idioma;
		this.experiencia = experiencia;
		this.remoto = remoto;
		this.licencia = licencia;
		this.graduado = graduado;
		this.tecnico = tecnico;
		this.obrero = obrero;
		this.tituloTecnico = tituloTecnico;
		this.area = area;
		this.habilidad = habilidad;
		this.empresa = empresa;
		this.empleados = new ArrayList<>();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTituloTecnico() {
		return tituloTecnico;
	}

	public void setTituloTecnico(String tituloTecnico) {
		this.tituloTecnico = tituloTecnico;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

	public boolean isGraduado() {
		return graduado;
	}

	public void setGraduado(boolean graduado) {
		this.graduado = graduado;
	}

	public boolean isTecnico() {
		return tecnico;
	}

	public void setTecnico(boolean tecnico) {
		this.tecnico = tecnico;
	}

	public boolean isObrero() {
		return obrero;
	}

	public void setObrero(boolean obrero) {
		this.obrero = obrero;
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

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Solicitante> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Solicitante> empleados) {
		this.empleados = empleados;
	}
}
