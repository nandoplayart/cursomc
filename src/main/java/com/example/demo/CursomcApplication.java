package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Repositories.CategoriaRepository;
import com.example.demo.Repositories.CidadeRepository;
import com.example.demo.Repositories.EstadoRepository;
import com.example.demo.Repositories.ProdutoRepository;
import com.example.demo.domain.Categoria;
import com.example.demo.domain.Cidade;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Produto;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cate1 = new Categoria(null,"Informatica");
		Categoria cate2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000);
		Produto p2 = new Produto(null,"Impressora",800);
		Produto p3 = new Produto(null,"mouse",80);
		
		
		cate1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cate2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cate1));
		p2.getCategorias().addAll(Arrays.asList(cate1,cate2));
		p3.getCategorias().addAll(Arrays.asList(cate1));
		

		Estado estado1 = new Estado(null,"Minas Gerais");
		Estado estado2 = new Estado(null,"São Paulo");
				
		Cidade cidade1 = new Cidade(null,"Uberlandia",estado1);
		Cidade cidade2= new Cidade(null,"São Paulo",estado2);
		Cidade cidade3= new Cidade(null,"Campinas",estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2,cidade3));
		
		categoriaRepository.saveAll(Arrays.asList(cate1,cate2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(estado1,estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3));
		
	}

}
