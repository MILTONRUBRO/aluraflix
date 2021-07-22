package br.com.mosdev.aluraflix.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mosdev.aluraflix.model.Video;

public class VideoDTO {
	
	private String titulo;
	private String descricao;
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
	
	public VideoDTO(Video video) {
		this.titulo = video.getTitulo();
		this.descricao = video.getDescricao();
		this.url = video.getUrl();
	}
	
	public static List<VideoDTO> convert(List<Video> videos){
		return videos.stream()
				.map(VideoDTO::new)
				.collect(Collectors.toList());
	}

}
