//projetobase
package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{
        //Endereco findByCep(String cep);
	List<Pais> findByNomeContainingOrderByNomeAsc(String nome);
	//Page<Pais> findByCepContainingAndNumeroContaining(String cep,String numero, Pageable pageable);
    
    

}

