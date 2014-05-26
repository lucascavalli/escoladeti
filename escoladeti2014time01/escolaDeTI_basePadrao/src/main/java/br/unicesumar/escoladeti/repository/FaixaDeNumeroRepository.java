package br.unicesumar.escoladeti.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import br.unicesumar.escoladeti.entity.FaixaDeNumero;

public interface FaixaDeNumeroRepository extends JpaRepository<FaixaDeNumero, Long>{
       
	FaixaDeNumero findByCep(String cep);

}

