package br.com.mosdev.aluraflix.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mosdev.aluraflix.errors.ResourceNotFoundException;
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

	@Override
	public Categoria getCategorie(Long id) {
		return categoriaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
	}

	@Override
	@Transactional
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

}