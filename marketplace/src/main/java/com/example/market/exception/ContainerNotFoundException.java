package com.example.market.exception;


public class ContainerNotFoundException extends RuntimeException {
	public ContainerNotFoundException(Long id) {
        super(id.toString());
    }

}
