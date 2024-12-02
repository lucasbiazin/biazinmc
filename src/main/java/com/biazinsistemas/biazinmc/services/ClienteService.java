package com.biazinsistemas.biazinmc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biazinsistemas.biazinmc.domain.Cliente;
import com.biazinsistemas.biazinmc.repositories.ClienteRepository;
import com.biazinsistemas.biazinmc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())));
	}

}
