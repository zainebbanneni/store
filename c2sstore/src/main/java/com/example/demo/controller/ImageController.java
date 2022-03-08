package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ImageService;
import com.example.demo.model.Image;
@RestController
@RequestMapping("/image")
public class ImageController {
	
private final ImageService imageService;
	

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }
    
 // create image
    @PostMapping("/add")
    public ResponseEntity<Image >addImage(@RequestBody Image img) {
    
    	imageService.addImage(img);
        ResponseEntity<Image> image= new ResponseEntity<Image>(img,HttpStatus.OK);
        return image;


    }
    
    
    @GetMapping("/all")
    public ResponseEntity<List<Image>> getAllImages () {
        List<Image> images = imageService.findAllImages();
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Image> getImageById (@PathVariable("id") Long id) {
    	Image image = imageService.findImageById(id);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

}
