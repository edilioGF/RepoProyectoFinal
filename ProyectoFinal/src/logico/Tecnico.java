package logico;

public class Tecnico extends Perfil {
	private String titulo;
	
	public Tecnico(String codigo , Solicitante solicitante, String idioma, boolean licencia, boolean mudarse, int experiencia,String titulo) {
		super(codigo , solicitante, idioma, licencia, mudarse, experiencia);
		this.titulo = titulo;
	}   

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
