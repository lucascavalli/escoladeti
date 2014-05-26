package br.unicesumar.escoladeti.service;

import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import static org.springframework.data.domain.Sort.Direction.ASC;

import java.util.List;

import org.springframework.data.domain.Sort;
import br.unicesumar.escoladeti.controller.DataPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.unicesumar.escoladeti.entity.Logradouro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unicesumar.escoladeti.repository.LogradouroRepository;

@Service

public class LogradouroService {
		
	private static final Logger logger = LoggerFactory.getLogger(LogradouroService.class);
	@Autowired
	private LogradouroRepository logradouroRepository;

	public LogradouroRepository getLogradouroRepository() {
		return logradouroRepository;
	}        
        
	public DataPage<Logradouro> getLogradouros(Integer pagina) {
		return new DataPage<>(logradouroRepository.findAll(pageRequestForAsc(pagina, "nome")));
	}

	public void salvar(Logradouro logradouro) {
		logradouroRepository.save(logradouro);
	}

	public Logradouro recuperarPeloId(Long id) {
		return logradouroRepository.findOne(id);
	}

	public void remover(Logradouro logradouro) {
		logradouroRepository.delete(logradouro);		
	}

	public List<Logradouro> getTodosLogradouros() {
		return logradouroRepository.findAll(new Sort(new Sort.Order(ASC, "nome")));
	}

        public Logradouro carregar(Long id) {
                return logradouroRepository.findOne(id);
        }
        

}
