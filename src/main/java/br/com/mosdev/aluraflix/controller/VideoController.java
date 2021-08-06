package br.com.mosdev.aluraflix.controller;

import java.util.List;
import java.util.logging.Level;
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
import org.springframework.web.bind.annotation.RequestParam;
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
		logger.log(Level.INFO, "Listando todos os videos");
		List<Video> videos = videoService.findAllVideos();
		return ResponseEntity.ok(VideoDTO.convert(videos));
	}
	
	@GetMapping("api/videos/{idVideo}")
	public ResponseEntity<VideoDTO> getVideo(@PathVariable("idVideo") Long idVideo) {
		logger.log(Level.INFO, "Buscando um video de id {0}", idVideo);
		Video video = videoService.getVideo(idVideo);
		return ResponseEntity.ok(new VideoDTO(video));
	}
	
	@PostMapping("api/videos")
	public ResponseEntity<VideoDTO> saveVideo(@Valid @RequestBody VideoRequest request){
		logger.log(Level.INFO, "Adicionando um novo video {0}", request);
		Video video = request.newVideo();
		return ResponseEntity.ok(new VideoDTO(videoService.save(video)));
	}
	
	@PutMapping("api/videos/{idVideo}")
	public ResponseEntity<VideoDTO> updateVideo(@Valid @RequestBody VideoRequest request, 
			@PathVariable("idVideo") Long idVideo){
		logger.log(Level.INFO, "Atualizando um video de id {0}", idVideo);
		Video video = request.newVideo(); 
		return ResponseEntity.ok(new VideoDTO(videoService.update(video, idVideo)));
	}
	
	@DeleteMapping("api/videos/{idVideo}")
	public ResponseEntity<Void> deleteVideo(@PathVariable("idVideo") Long idVideo) {
		logger.log(Level.INFO, "Deletando um video de id {0}", idVideo);
		videoService.delete(idVideo);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("api/videos/search")
	public ResponseEntity<List<VideoDTO>> searchVideoByTitle(@RequestParam String titulo){
		logger.log(Level.INFO, "Buscando um video com o titulo {0}", titulo);
		List<Video> videos = videoService.findVideoByTitulo(titulo);
		return ResponseEntity.ok().body(VideoDTO.convert(videos));
	}

}
