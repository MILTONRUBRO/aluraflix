package br.com.mosdev.aluraflix.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mosdev.aluraflix.model.Categoria;
import br.com.mosdev.aluraflix.repository.CategoriaRepository;
import br.com.mosdev.aluraflix.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> findAllCategories() {
		return categoriaRepository.findAll();
	}

}
