package br.com.zupacademy.guzzo.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.guzzo.casadocodigo.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
