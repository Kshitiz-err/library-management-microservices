package com.library.catalogserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogServerApplication {

	public static void main(String[] args) {
        System.out.println("CatalogServerApplication is running");
		SpringApplication.run(CatalogServerApplication.class, args);
	}

}
