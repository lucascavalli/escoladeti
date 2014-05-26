
package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Cidade;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    public List<Cidade> findByNome(String nome, int codigoIbge);        
    
}
