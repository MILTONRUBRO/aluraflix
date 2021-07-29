package br.com.mosdev.aluraflix.model;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {
	
	@NotBlank(message = "O titulo não pode ser vazio")
	private String titulo;
	
	@NotBlank(message = "A cor não pode ser vazia")	
	private String cor;

	public CategoriaRequest(@NotBlank String titulo, @NotBlank String cor) {
		this.titulo = titulo;
		this.cor = cor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public Categoria newCategoria() {
		return new Categoria(titulo, cor);
	}

}
