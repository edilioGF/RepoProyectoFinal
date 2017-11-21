package logico;

public class Tecnico extends Solicitante {
	private String titulo;

	public Tecnico(String cedula, String nombre, String apellidos, String nacimiento, String genero, String paisOrigen,
			String paisResidencia, String titulo) {
		super(cedula, nombre, apellidos, nacimiento, genero, paisOrigen, paisResidencia);
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
