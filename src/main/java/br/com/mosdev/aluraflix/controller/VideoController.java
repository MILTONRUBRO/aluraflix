package br.com.mosdev.aluraflix.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	private static final Logger logger = Logger.getLogger( VideoController.class.getName() );
	
	@GetMapping("api/videos")
	public ResponseEntity<List<VideoDTO>> listAllVideos(){
		logger.info("Busca todos os videos");
		List<Video> videos = videoService.findAllVideos();
		return ResponseEntity.ok(VideoDTO.convert(videos));
	}
	
	@GetMapping("api/videos/{idVideo}")
	public ResponseEntity<VideoDTO> getVideo(@PathVariable("idVideo") Long idVideo) {
		logger.info("Busca um video de id: " + idVideo);
		Video video = videoService.getVideo(idVideo);
		return ResponseEntity.ok(new VideoDTO(video));
	}
	
	@PostMapping("api/videos")
	public ResponseEntity<VideoDTO> saveVideo(@Valid @RequestBody VideoRequest request){
		logger.info("Adicionando um novo video");
		Video video = request.newVideo();
		return ResponseEntity.ok(new VideoDTO(videoService.save(video)));
	}
	
	@PutMapping("api/videos/{idVideo}")
	public ResponseEntity<VideoDTO> updateVideo(@Valid @RequestBody VideoRequest request, 
			@PathVariable("idVideo") Long idVideo){
		logger.info("Atualizar video de id: " + idVideo);

		Video video = request.newVideo(); 
		return ResponseEntity.ok(new VideoDTO(videoService.update(video, idVideo)));
	}
	
	@DeleteMapping("api/videos/{idVideo}")
	public ResponseEntity<Void> deleteVideo(@PathVariable("idVideo") Long idVideo) {
		logger.info("Deletar video de id: " + idVideo);
		videoService.delete(idVideo);
		return ResponseEntity.ok().build();
	}

}
