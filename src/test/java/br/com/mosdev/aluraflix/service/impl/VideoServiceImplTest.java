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

import br.com.mosdev.aluraflix.model.Video;
import br.com.mosdev.aluraflix.repository.VideoRepository;
import br.com.mosdev.aluraflix.service.VideoService;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class VideoServiceImplTest {
	
	@MockBean
	private VideoRepository  videoRepository;
	
	@Autowired
	private VideoService videoService;
	
	private static final String TITULO = "Alien o oitavo passageiro";
	private static final String DESCRICAO = "Aliens, suspense e drama";
	private static final String URL = "https://www.youtube.com/watch?v=Hdki9ZDbI4ke";


	@Test
	public void testSaveVideo() {
		BDDMockito.given(videoRepository.save(Mockito.any(Video.class))).willReturn(getMockVideo());
		Video videoSaved = videoService.save(new Video());
		
		assertNotNull(videoSaved);
	}
	
	@Test
	public void testGetVideo() {
		BDDMockito.given(videoRepository.findById(Mockito.any())).willReturn(Optional.of(getMockVideo()));
		Video videoSaved = videoService.getVideo(1L);
		
		assertNotNull(videoSaved);
	}

	private Video getMockVideo() {
		return new Video(TITULO, DESCRICAO, URL);
	}

}
