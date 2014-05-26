
package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Uf;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UfRepository extends JpaRepository<Uf, Long> {


    public List<Uf> findByNomeContainingAndCodigoIbgeContainingOrderByIdAsc(String nome, int codigoIbge);
    

    
    
}
