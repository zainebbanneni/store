/*package com.example.market.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.market.model.Container;
import com.example.market.repo.ContainerRepository;


@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ContainerRepositoryTest {
	
	@Autowired
	private final ContainerRepository containerRepository;
	
	 @Test
	    void testSaveMethod() throws InterruptedException {
	        Container container = getContainer();

	        // save container
	        containerRepository.save(container);
	    }

	    @Test
	    void testUpdateMethod() throws InterruptedException {
	        Container container = getContainer();

	        // save container
	        Container savedContainer = containerRepository.save(container);

	        savedContainer.setName("marketplace");
	        savedContainer.setPort(8080);

	        // update product
	        Container updatedContainer = containerRepository.save(savedContainer);

	        System.out.println(updatedContainer.getName());
	        System.out.println(updatedContainer.getPort());
	    }

	    @Test
	    void testSaveAllMethod(){
	        Container container= getContainer();

	        Container container2 = new Container();
	        container2.setName("product 2");
	        container2.setPort(8181);
	        container2.setImage(image);
	        container2.setUser(user);

	        containerRepository.saveAll(List.of(container, container2));
	    }

	    @Test
	    void testFindByIdMethod(){
	        Container container = getContainer();

	        // save product
	        containerRepository.save(container);

	        // get product by id
	        Container savedContainer = containerRepository.findById(container.getId()).get();

	        System.out.println(savedContainer.getName());
	    }

	    @Test
	    void testFindAllMethod(){
	        Container container = getContainer();

	        Container container2 = getContainer2();

	        containerRepository.saveAll(List.of(container, container2));

	        containerRepository.findAll().forEach((p) -> {
	            System.out.println(p.getName());
	        });
	    }

}*/
