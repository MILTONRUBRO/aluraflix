package br.com.mosdev.aluraflix.model.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.mosdev.aluraflix.model.Categoria;
import br.com.mosdev.aluraflix.model.Video;

public class CategoriaVideoDTO {
	
	private Long id;
	private String titulo;
	private String cor;
	private List<Video> videos = new ArrayList<>();
	
	
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
	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
