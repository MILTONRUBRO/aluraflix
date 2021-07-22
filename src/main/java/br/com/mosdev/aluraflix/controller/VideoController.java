package br.com.mosdev.aluraflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mosdev.aluraflix.model.Video;
import br.com.mosdev.aluraflix.model.dto.VideoDTO;
import br.com.mosdev.aluraflix.service.VideoService;

@RestController
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	
	@GetMapping("api/livros")
	public ResponseEntity<List<VideoDTO>> listAllVideos(){
		List<Video> videos = videoService.findAllVideos();
		return ResponseEntity.ok(VideoDTO.convert(videos));
	}

}
