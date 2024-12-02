package com.biazinsistemas.biazinmc.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.biazinsistemas.biazinmc.domain.Categoria;
import com.biazinsistemas.biazinmc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.find(id);
		return ResponseEntity.ok(obj);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		String message = service.removeById(id);
		return ResponseEntity.ok(message);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Categoria cat) {
		cat = service.create(cat);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cat.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

}
