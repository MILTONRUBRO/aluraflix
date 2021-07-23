package br.com.mosdev.aluraflix.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class VideoRequest {
	
	@NotBlank
	@Size(min = 5, message = "Titulo deve ter no minimo 5 caracteres")
	private String titulo;
	@NotBlank
	@Size(min = 5, message = "Titulo deve ter no minimo 5 caracteres")
	private String descricao;
	@NotBlank
	@Size(min = 5, message = "Titulo deve ter no minimo 20 caracteres")
	private String url;
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public VideoRequest(String titulo, String descricao, String url) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.url = url;
	}

	public Video newVideo() {
		return new Video(titulo, descricao,url);
	}

}
