package com.biazinsistemas.biazinmc.services;

import java.util.Optional;

import com.biazinsistemas.biazinmc.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biazinsistemas.biazinmc.domain.Categoria;
import com.biazinsistemas.biazinmc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())));
	}

	public String removeById(Integer id) {
		repo.deleteById(id);
		return "Usuário excluído com sucesso";
	}

}
