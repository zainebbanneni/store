package com.example.market.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.exception.UserNotFoundException;
import com.example.market.model.Container;
import com.example.market.model.Image;
import com.example.market.repo.ImageRepository;

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
    
    public Image findImageByName(String imageName) {
		return imageRepository.findImageByName(imageName)
				.orElseThrow(() -> new UserNotFoundException("Image by name " + imageName + " was not found"));
	}
    

    
}
