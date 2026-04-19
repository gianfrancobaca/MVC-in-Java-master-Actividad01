package models;

public class Invitado {
	private String nombre;
	private String celular;
	private String genero;

	public Invitado(String nombre, String celular, String genero) {
		this.nombre = nombre;
		this.celular = celular;
		this.genero = genero;
	}

	public String getNombre() { return nombre; }
	public String getCelular() { return celular; }
	public String getGenero() { return genero; }


}