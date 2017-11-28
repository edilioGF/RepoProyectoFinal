package logico;

public class Tecnico extends Solicitud {
	private String titulo;
	
	public Tecnico(Solicitante solicitante, String idioma, boolean licencia, boolean mudarse, int experiencia,String titulo) {
		super(solicitante, idioma, licencia, mudarse, experiencia);
		this.titulo = titulo;
	}   

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
