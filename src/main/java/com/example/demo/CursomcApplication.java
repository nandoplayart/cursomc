package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Repositories.CategoriaRepository;
import com.example.demo.Repositories.ProdutoRepository;
import com.example.demo.domain.Categoria;
import com.example.demo.domain.Produto;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
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
		
		
		categoriaRepository.saveAll(Arrays.asList(cate1,cate2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}
