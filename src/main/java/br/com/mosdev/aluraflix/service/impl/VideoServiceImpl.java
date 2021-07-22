package br.com.mosdev.aluraflix.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
