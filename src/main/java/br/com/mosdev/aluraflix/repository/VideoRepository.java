package br.com.mosdev.aluraflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mosdev.aluraflix.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{
	
	List<Video> findByTituloContainingIgnoreCase(String titulo);

}
