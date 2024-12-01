package com.biazinsistemas.biazinmc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biazinsistemas.biazinmc.domain.Categoria;
import com.biazinsistemas.biazinmc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada! Id:" + id));
	}

	public void removeById(Integer id) {
		repo.deleteById(id);
	}

}
