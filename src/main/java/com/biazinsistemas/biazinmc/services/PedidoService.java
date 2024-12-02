package com.biazinsistemas.biazinmc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biazinsistemas.biazinmc.domain.Pedido;
import com.biazinsistemas.biazinmc.repositories.PedidoRepository;
import com.biazinsistemas.biazinmc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())));
	}

}
