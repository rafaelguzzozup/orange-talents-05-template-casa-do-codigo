package br.com.zupacademy.guzzo.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.guzzo.casadocodigo.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

	Optional<Autor> findByEmail(String email);

}
