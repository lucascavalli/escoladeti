package br.unicesumar.escoladeti.service;

import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import static org.springframework.data.domain.Sort.Direction.ASC;

import java.util.List;

import org.springframework.data.domain.Sort;
import br.unicesumar.escoladeti.controller.DataPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.unicesumar.escoladeti.entity.FaixaDeNumero;
import br.unicesumar.escoladeti.repository.FaixaDeNumeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class FaixaDeNumeroService {
		
	private static final Logger logger = LoggerFactory.getLogger(FaixaDeNumeroService.class);
	@Autowired
	private FaixaDeNumeroRepository faixaDeNumeroRepository;

	public FaixaDeNumeroRepository getFaixaDeNumeroRepository() {
		return faixaDeNumeroRepository;
	}        
        
	public DataPage<FaixaDeNumero> getFaixasDeNumero(Integer pagina) {
		return new DataPage<>(faixaDeNumeroRepository.findAll(pageRequestForAsc(pagina, "cep")));
	}

	public void salvar(FaixaDeNumero faixaDeNumero) {
		faixaDeNumeroRepository.save(faixaDeNumero);
	}

	public FaixaDeNumero recuperarPeloId(Long id) {
		return faixaDeNumeroRepository.findOne(id);
	}

	public void remover(FaixaDeNumero faixaDeNumero) {
		faixaDeNumeroRepository.delete(faixaDeNumero);		
	}

	public List<FaixaDeNumero> getTodasFaixasDeNumero() {
		return faixaDeNumeroRepository.findAll(new Sort(new Sort.Order(ASC, "cep")));
	}

        public FaixaDeNumero carregar(Long id) {
                return faixaDeNumeroRepository.findOne(id);
        }
        

}
