package com.example.demo.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.CategoriaRepository;
import com.example.demo.domain.Categoria;

@Service
public class CategoriaService {
	//injeção de dependencia é automatica acrescentado o atributo @Autowired
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		
	 Optional<Categoria> categoria =repo.findById(id);
	 //return categoria.orElse(null);
	 
	 return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " 
			 + id + " , Tipo " + Categoria.class.getName(), null));
	}
	
	public Categoria inserir(Categoria categoria) {
		return repo.save(categoria);
	}
}
