package br.com.mosdev.aluraflix.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mosdev.aluraflix.errors.ResourceNotFoundException;
import br.com.mosdev.aluraflix.model.Video;
import br.com.mosdev.aluraflix.repository.VideoRepository;
import br.com.mosdev.aluraflix.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{
	
	@Autowired
	private VideoRepository videoRepository;

	@Override
	public List<Video> findAllVideos() {
		return videoRepository.findAll();
	}

	@Override
	public Video getVideo(Long idVideo) {
		Optional<Video> video = videoRepository.findById(idVideo);
		
		if(!video.isPresent()) {
			throw new ResourceNotFoundException();
		}
		
		return video.get();
	}

	@Transactional
	@Override
	public Video save(Video video) {
		return videoRepository.save(video);
	}
}
