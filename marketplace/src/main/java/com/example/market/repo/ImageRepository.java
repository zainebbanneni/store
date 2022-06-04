package com.example.market.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.market.model.Container;
import com.example.market.model.Image;
@Repository
public interface ImageRepository extends JpaRepository<Image, Long>  {
	Optional<Image> findImageById(Long id);
	Optional<Image> findImageByName(String imageName);
	
	void getImageByName(String containerName);



	Image findByName(String string);


}
