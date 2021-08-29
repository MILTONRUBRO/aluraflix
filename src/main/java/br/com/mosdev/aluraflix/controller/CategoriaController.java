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
import org.springframework.web.bind.annotation.RestController;

import br.com.mosdev.aluraflix.model.Categoria;
import br.com.mosdev.aluraflix.model.CategoriaRequest;
import br.com.mosdev.aluraflix.model.Video;
import br.com.mosdev.aluraflix.model.dto.CategoriaDTO;
import br.com.mosdev.aluraflix.model.dto.VideoDTO;
import br.com.mosdev.aluraflix.service.CategoriaService;

@RestController
public class CategoriaController {
	
	private static final Logger logger = Logger.getLogger( CategoriaController.class.getName() );

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("api/categorias")
	public ResponseEntity<List<Categoria>> getAllCategories(){
		logger.log(Level.INFO, "Buscando todas as categorias");
		return ResponseEntity.ok(categoriaService.findAllCategories());
	}
	
	@GetMapping("api/categorias/{id}")
	public ResponseEntity<Categoria> getCategorie(@PathVariable("id") Long id){
		logger.log(Level.INFO, "Buscando uma categoria pelo id: {0}", id);
		return ResponseEntity.ok(categoriaService.getCategorie(id));
	}
	
	@PostMapping("api/categorias")
	public ResponseEntity<CategoriaDTO> saveCategorie(@RequestBody @Valid CategoriaRequest request) {
		logger.log(Level.INFO, "Salvando uma nova categoria {0}", request);
		Categoria categoria = request.newCategoria();
		return ResponseEntity.ok(new CategoriaDTO(categoriaService.save(categoria)));
	}
	
	
	@PutMapping("api/categorias/{id}")
	public ResponseEntity<CategoriaDTO> updateCategorie(@RequestBody @Valid CategoriaRequest request, @PathVariable("id") Long id) {
		logger.log(Level.INFO, "Atualizando a categoria de id {0}", id);
		Categoria categoria = request.newCategoria();
		return ResponseEntity.ok(new CategoriaDTO(categoriaService.update(id, categoria)));
	}
	
	@DeleteMapping("api/categorias/{id}")
	public ResponseEntity<Void> deleteVideo(@PathVariable("id") Long id) {
		logger.log(Level.INFO, "Deletando a categoria de id {0}", id);
		categoriaService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("api/categorias/{id}/videos")
	public ResponseEntity<List<VideoDTO>> listCategorieAndVideos(@PathVariable long id) {
		logger.log(Level.INFO, "Listando as categorias de id {0}", id);
		List<Video> categoriaVideos = categoriaService.findCategorieAndVideo(id);
		return ResponseEntity.ok().body(VideoDTO.convert(categoriaVideos) );
	}

}
