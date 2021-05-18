package br.com.zupacademy.guzzo.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.guzzo.casadocodigo.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
