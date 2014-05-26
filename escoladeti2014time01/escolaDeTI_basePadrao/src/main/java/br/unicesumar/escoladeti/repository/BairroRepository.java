package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Bairro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BairroRepository extends JpaRepository<Bairro, Long>{
    
    public List<Bairro> findByNome(String nome);
}
