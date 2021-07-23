package br.com.mosdev.aluraflix.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mosdev.aluraflix.model.Video;
import br.com.mosdev.aluraflix.model.VideoRequest;
import br.com.mosdev.aluraflix.model.dto.VideoDTO;
import br.com.mosdev.aluraflix.service.VideoService;

@RestController
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	
	@GetMapping("api/videos")
	public ResponseEntity<List<VideoDTO>> listAllVideos(){
		List<Video> videos = videoService.findAllVideos();
		return ResponseEntity.ok(VideoDTO.convert(videos));
	}
	
	@GetMapping("api/videos/{idVideo}")
	public ResponseEntity<VideoDTO> getVideo(@PathVariable("idVideo") Long idVideo) {
		Video video = videoService.getVideo(idVideo);
		return ResponseEntity.ok(new VideoDTO(video));
	}
	
	@PostMapping("api/videos")
	public ResponseEntity<VideoDTO> saveVideo(@Valid @RequestBody VideoRequest request){
		Video video = request.newVideo();
		return ResponseEntity.ok(new VideoDTO(videoService.save(video)));
	}

}
