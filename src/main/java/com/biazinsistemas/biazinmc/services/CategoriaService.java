package com.biazinsistemas.biazinmc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.biazinsistemas.biazinmc.domain.Categoria;
import com.biazinsistemas.biazinmc.dto.CategoriaDTO;
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

	public void remove(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.biazinsistemas.biazinmc.services.exception.DataIntegrityViolationException(
					"Não é possível remover uma categoria que possui produtos!");
		}
	}

	public Categoria create(Categoria cat) {
		cat.setId(null);
		return repo.save(cat);
	}

	public Categoria update(Categoria newCat) {
		find(newCat.getId());
		return repo.save(newCat);
	}

	public List<Categoria> listAll() {
		return repo.findAll();
	}

	public Page<Categoria> pageAll(Integer page, Integer linePerPage, String orderBy, String direction) {
	    Sort.Direction sortDirection = Sort.Direction.fromString(direction);
	    PageRequest pageRequest = PageRequest.of(page, linePerPage, Sort.by(sortDirection, orderBy)); 
	    return repo.findAll(pageRequest); 
	}
	
	public Categoria fromDto(CategoriaDTO dto) {
		return new Categoria(dto.getId(), dto.getNome());
	}
	

}
