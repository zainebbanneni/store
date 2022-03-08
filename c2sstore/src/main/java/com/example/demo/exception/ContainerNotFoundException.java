package com.example.demo.exception;


public class ContainerNotFoundException extends RuntimeException {
	public ContainerNotFoundException(Long id) {
        super(id.toString());
    }

}
