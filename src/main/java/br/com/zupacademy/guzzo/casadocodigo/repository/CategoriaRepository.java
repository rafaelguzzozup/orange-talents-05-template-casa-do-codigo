package br.com.zupacademy.guzzo.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.guzzo.casadocodigo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Optional<Categoria> findByNomeIgnoreCase(String nome);

}
