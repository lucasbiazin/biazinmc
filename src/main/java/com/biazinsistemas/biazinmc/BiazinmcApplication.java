package com.biazinsistemas.biazinmc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.biazinsistemas.biazinmc.domain.Categoria;
import com.biazinsistemas.biazinmc.domain.Cidade;
import com.biazinsistemas.biazinmc.domain.Estado;
import com.biazinsistemas.biazinmc.domain.Produto;
import com.biazinsistemas.biazinmc.repositories.CategoriaRepository;
import com.biazinsistemas.biazinmc.repositories.CidadeRepository;
import com.biazinsistemas.biazinmc.repositories.EstadoRepository;
import com.biazinsistemas.biazinmc.repositories.ProdutoRepository;

@SpringBootApplication
public class BiazinmcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(BiazinmcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado es1 = new Estado(null, "Paraná");
		Estado es2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Curitiba", es1);
		Cidade c2 = new Cidade(null, "Maringá", es1);
		Cidade c3 = new Cidade(null, "São Paulo", es2);

		es1.getCidades().addAll(Arrays.asList(c1, c2));
		es2.getCidades().addAll(Arrays.asList(c3));

		estadoRepository.saveAll(Arrays.asList(es1, es2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

	}
}
