package br.com.mosdev.aluraflix.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.mosdev.aluraflix.model.Categoria;
import br.com.mosdev.aluraflix.repository.CategoriaRepository;
import br.com.mosdev.aluraflix.service.CategoriaService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CategoriaServiceImplTest {
	
	@MockBean
	private CategoriaRepository  categoriaRepository;
	
	@Autowired
	private CategoriaService  categoriaService;
	
	private static final Long ID = 1L;
	private static final String TITULO = "Titulo teste";
	private static final String COR = "azul";

	@Test
	public void testSaveCategorie() {
		BDDMockito.given(categoriaRepository.save(Mockito.any(Categoria.class))).willReturn(getCategoria());
		Categoria categorie = categoriaService.save(new Categoria());
		
		assertNotNull(categorie);
	}
	
	@Test
	public void testGetCategorie() {
		BDDMockito.given(categoriaRepository.findById(Mockito.anyLong())).willReturn(Optional.of(getCategoria()));
		Categoria categorie = categoriaService.getCategorie(ID);
		
		assertNotNull(categorie);
	}

	private Categoria getCategoria() {
		return new Categoria(TITULO, COR);
	}

}
