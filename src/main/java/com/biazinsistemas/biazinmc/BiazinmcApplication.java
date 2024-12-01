package com.biazinsistemas.biazinmc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.biazinsistemas.biazinmc.domain.Categoria;
import com.biazinsistemas.biazinmc.repositories.CategoriaRepository;

@SpringBootApplication
public class BiazinmcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(BiazinmcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		repository.saveAll(Arrays.asList(cat1,cat2));
		
		
	}
}
