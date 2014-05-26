//projetobase
package br.unicesumar.escoladeti.service;

import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import static org.springframework.data.domain.Sort.Direction.ASC;

import java.util.List;

import org.springframework.data.domain.Sort;
import br.unicesumar.escoladeti.controller.DataPage;    
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.unicesumar.escoladeti.entity.Pais;
import br.unicesumar.escoladeti.repository.PaisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
public class PaisService {
  
    
	@Autowired
	private PaisRepository paisRepository;

	public PaisRepository getPaisRepository() {
		return paisRepository;
	} 
        
        public DataPage<Pais> getPaises(Integer pagina) {
		return new DataPage<>(paisRepository.findAll(pageRequestForAsc(pagina, "nome")));
	}

	public void salvar(Pais pais) {
		paisRepository.save(pais);
	}

	public Pais recuperarPeloId(Long id) {
		return paisRepository.findOne(id);
	}

	public void remover(Pais pais) {
		paisRepository.delete(pais);
                        	
	}

	public List<Pais> getTodosPaises() {
		return paisRepository.findAll(new Sort(new Sort.Order(ASC, "nome")));
	}

        public Pais carregar(Long id) {
                return paisRepository.findOne(id);
        }
       

}
