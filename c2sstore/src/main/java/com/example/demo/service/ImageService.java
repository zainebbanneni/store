package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Image;
import com.example.demo.repo.ImageRepository;

@Service
@Transactional
public class ImageService {
	private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    
    public void addImage(Image img) {
		imageRepository.save(img);
		
	}
    
    public List<Image> findAllImages() {
        return imageRepository.findAll();
    }
    public Image findImageById(Long id) {
        return imageRepository.findImageById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

}
