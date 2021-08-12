package br.com.mosdev.aluraflix.model.dto;

import br.com.mosdev.aluraflix.model.Categoria;

public class CategoriaDTO {

	private String cor;
	private String titulo;

	public CategoriaDTO(String cor, String titulo) {
		this.cor = cor;
		this.titulo = titulo;
	}

	public CategoriaDTO(Categoria categoria) {
		this.titulo = categoria.getTitulo();
		this.cor = categoria.getCor();
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Override
	public String toString() {
		return "Cor: " + cor + "--" + "Titulo: " + titulo;
	}
	
}
