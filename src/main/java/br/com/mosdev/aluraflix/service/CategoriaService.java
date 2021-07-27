package br.com.mosdev.aluraflix.service;

import java.util.List;

import br.com.mosdev.aluraflix.model.Categoria;

public interface CategoriaService {
	
	List<Categoria> findAllCategories();

}
