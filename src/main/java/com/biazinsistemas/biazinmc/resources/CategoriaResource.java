package com.biazinsistemas.biazinmc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biazinsistemas.biazinmc.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@GetMapping
	public List<Categoria> listAll () {
	
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria (2, "Escritório");
		
		List<Categoria> categorias = new ArrayList<>();
		
		categorias.add(cat1);
		categorias.add(cat2);

		
		return categorias;
	}
}
