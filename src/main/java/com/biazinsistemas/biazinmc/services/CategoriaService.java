package com.biazinsistemas.biazinmc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biazinsistemas.biazinmc.domain.Categoria;
import com.biazinsistemas.biazinmc.repositories.CategoriaRepository;
import com.biazinsistemas.biazinmc.services.exception.ObjectNotFoundException;

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

	public Categoria create(Categoria cat) {
		cat.setId(null);
		return repo.save(cat);
	}

	public Categoria update(Categoria newCat) {
		find(newCat.getId());
		return repo.save(newCat);
	}

}
