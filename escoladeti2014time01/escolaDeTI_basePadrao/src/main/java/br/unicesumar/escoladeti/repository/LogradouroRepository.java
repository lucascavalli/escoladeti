package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Logradouro;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {
	
	Logradouro findByNome(String nome);

}
