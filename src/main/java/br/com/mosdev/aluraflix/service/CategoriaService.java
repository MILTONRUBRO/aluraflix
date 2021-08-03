package br.com.mosdev.aluraflix.service;

import java.util.List;

import br.com.mosdev.aluraflix.model.Categoria;
import br.com.mosdev.aluraflix.model.Video;
import br.com.mosdev.aluraflix.model.dto.VideoDTO;

public interface CategoriaService {
	
	List<Categoria> findAllCategories();
	Categoria getCategorie(Long id);
	Categoria save(Categoria categoria);
	Categoria update(Long id, Categoria categoria);
	void delete(Long id);
	List<Video> findCategorieAndVideo(Long id);

}
