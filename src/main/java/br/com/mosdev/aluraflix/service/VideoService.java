package br.com.mosdev.aluraflix.service;

import java.util.List;

import br.com.mosdev.aluraflix.model.Video;

public interface VideoService {
	List<Video> findAllVideos();
	Video getVideo(Long idVideo);
	Video save(Video video);
	Video update(Video video, Long idVideo);
	void delete(Long idVideo);
	List<Video> findVideoByTitulo(String titulo); 
}
