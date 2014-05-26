
package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Distrito;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DistritoRepository extends JpaRepository<Distrito, Long> {

    public List<Distrito> findByDistrito(String nome);        
    
}
