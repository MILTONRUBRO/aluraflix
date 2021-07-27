package br.com.mosdev.aluraflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mosdev.aluraflix.model.Categoria;
import br.com.mosdev.aluraflix.service.CategoriaService;

@RestController
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("api/categorias")
	public ResponseEntity<List<Categoria>> getAllCategories(){
		return ResponseEntity.ok(categoriaService.findAllCategories());
	}

}
