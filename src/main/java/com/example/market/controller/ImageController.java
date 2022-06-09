package com.example.market.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.exception.ResourceNotFoundException;
import com.example.market.model.Container;
import com.example.market.model.Image;
import com.example.market.model.Project;
import com.example.market.model.StoreRequest;
import com.example.market.model.User;
import com.example.market.repo.ImageRepository;
import com.example.market.service.ImageService;
import com.example.market.service.UtilityService;
@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImageController {
	@Autowired
	private UtilityService utilityService;
	@Autowired
	private ImageRepository imageRepository;
	
private final ImageService imageService;
	

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }
    
    
    /*@GetMapping("/getImage")
	public ResponseEntity<List<Image>> getAllImages () {
		String[] lines = { "docker image ls --format \"table {{.Repository}} {{.Tag}}\"" };

		try {
			utilityService.executeCommands(lines);

		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Image> images = imageService.findAllImages();
		return new ResponseEntity<>(images, HttpStatus.OK);
        


	}*/
    
    @PostMapping("/img")
	private void createImage(@RequestBody StoreRequest storeRequest) {

		String port = null;
		String imageName = utilityService.generateRoandomNames();
		String[] lines = { "docker build -t" + imageName };
		String[] lines3 = { "docker image ls" };

		try {
			utilityService.executeCommands(lines);
			port = utilityService.executeCommands(lines3);

		} catch (IOException e) {
			e.printStackTrace();
		}
		Image image = new Image (imageName);

		imageRepository.save(image);
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
    
 // get image by id rest api
 	/*@GetMapping("/images/{id}")
 	public ResponseEntity<Image> getImageById(@PathVariable Long id) {
 		Image image = imageRepository.findById(id)
 				.orElseThrow(() -> new ResourceNotFoundException("Image not exist with id :" + id));
 		return ResponseEntity.ok(image);
 	}*/

}
