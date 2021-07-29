package br.com.mosdev.aluraflix.model;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {
	
	@NotBlank
	private String titulo;
	
	@NotBlank
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
	

}
