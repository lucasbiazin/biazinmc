package com.biazinsistemas.biazinmc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.biazinsistemas.biazinmc.domain.Categoria;
import com.biazinsistemas.biazinmc.domain.Cidade;
import com.biazinsistemas.biazinmc.domain.Cliente;
import com.biazinsistemas.biazinmc.domain.Endereco;
import com.biazinsistemas.biazinmc.domain.Estado;
import com.biazinsistemas.biazinmc.domain.Pagamento;
import com.biazinsistemas.biazinmc.domain.PagamentoComBoleto;
import com.biazinsistemas.biazinmc.domain.PagamentoComCartao;
import com.biazinsistemas.biazinmc.domain.Pedido;
import com.biazinsistemas.biazinmc.domain.Produto;
import com.biazinsistemas.biazinmc.domain.enums.EstadoPagamento;
import com.biazinsistemas.biazinmc.domain.enums.TipoCliente;
import com.biazinsistemas.biazinmc.repositories.CategoriaRepository;
import com.biazinsistemas.biazinmc.repositories.CidadeRepository;
import com.biazinsistemas.biazinmc.repositories.ClienteRepository;
import com.biazinsistemas.biazinmc.repositories.EnderecoRepository;
import com.biazinsistemas.biazinmc.repositories.EstadoRepository;
import com.biazinsistemas.biazinmc.repositories.PagamentoRepository;
import com.biazinsistemas.biazinmc.repositories.PedidoRepository;
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

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	PagamentoRepository pagamentoRepository;

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

		Cliente cliente1 = new Cliente(null, "Lucas", "lucas@gmail.com", "11111111111", TipoCliente.PESSOAFISICA);
		Cliente cliente2 = new Cliente(null, "Tiago", "tiago@gmail.com", "22222222222", TipoCliente.PESSOAFISICA);
		Cliente cliente3 = new Cliente(null, "Carlos", "carlos@gmail.com", "33333333333", TipoCliente.PESSOAFISICA);
		Cliente cliente4 = new Cliente(null, "Biazin Sistemas", "biazinsistemas@gmail.com", "55555555555555",
				TipoCliente.PESSOAJURIDICA);

		cliente1.getTelefones().addAll(Arrays.asList("44999991803", "44999999999"));
		cliente2.getTelefones().addAll(Arrays.asList("44999991804", "44999999998"));
		cliente3.getTelefones().addAll(Arrays.asList("44999991805", "44999999997"));
		cliente4.getTelefones().addAll(Arrays.asList("44999991806", "44999999996"));

		Endereco end1 = new Endereco(null, "Rua das araras", "10", "N/A", "CENTRO", "87240000", cliente1, c1);
		Endereco end2 = new Endereco(null, "Rua das capivaras", "20", "N/A", "CENTRO", "87240000", cliente1, c2);
		Endereco end3 = new Endereco(null, "Rua dos cachorro", "30", "N/A", "CENTRO", "87240000", cliente2, c2);
		Endereco end4 = new Endereco(null, "Rua dos cavalo", "40", "N/A", "CENTRO", "87240000", cliente2, c3);
		Endereco end5 = new Endereco(null, "Rua dos cachorro", "30", "N/A", "CENTRO", "87240000", cliente3, c2);
		Endereco end6 = new Endereco(null, "Rua dos cavalo", "40", "N/A", "CENTRO", "87240000", cliente3, c3);
		Endereco end7 = new Endereco(null, "Rua das araras", "10", "N/A", "CENTRO", "87240000", cliente4, c1);

		cliente1.getEnderecos().addAll(Arrays.asList(end1, end2));
		cliente2.getEnderecos().addAll(Arrays.asList(end2, end3));
		cliente3.getEnderecos().addAll(Arrays.asList(end5, end6));
		cliente4.getEnderecos().addAll(Arrays.asList(end1));

		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3, cliente4));
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3, end4, end5, end6, end7));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("01/12/2024 23:04"), cliente1, end1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/12/2024 22:19"), cliente2, end2);
		Pedido ped3 = new Pedido(null, sdf.parse("13/12/2024 22:35"), cliente3, end3);
		Pedido ped4 = new Pedido(null, sdf.parse("14/12/2024 22:45"), cliente4, end3);
		Pedido ped5 = new Pedido(null, sdf.parse("18/12/2024 22:22"), cliente4, end3);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		Pagamento pagto2 = new PagamentoComCartao(null, EstadoPagamento.PENDENTE, ped2, 3);
		Pagamento pagto3 = new PagamentoComCartao(null, EstadoPagamento.CANCELADO, ped3, 3);
		Pagamento pagto4 = new PagamentoComBoleto(null, EstadoPagamento.QUITADO, ped4, sdf.parse("15/12/2024 15:30"),sdf.parse("01/12/2024 16:25"));
		Pagamento pagto5 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped5, sdf.parse("15/12/2024 17:55"), null);

		ped1.setPagamento(pagto1);
		ped2.setPagamento(pagto2);
		ped3.setPagamento(pagto3);
		ped4.setPagamento(pagto4);
		ped5.setPagamento(pagto5);
		
		cliente1.getPedidos().addAll(Arrays.asList(ped1));
		cliente2.getPedidos().addAll(Arrays.asList(ped2));
		cliente4.getPedidos().addAll(Arrays.asList(ped3));
		cliente4.getPedidos().addAll(Arrays.asList(ped4));
		cliente4.getPedidos().addAll(Arrays.asList(ped5));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2,ped3,ped4,ped5));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2,pagto3,pagto4,pagto5));
		
	}
}
