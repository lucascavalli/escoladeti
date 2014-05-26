package br.unicesumar.escoladeti.service;

import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import static org.springframework.data.domain.Sort.Direction.ASC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.entity.Cidade;
import br.unicesumar.escoladeti.repository.CidadeRepository;

@Service
public class CidadeService {
	@Autowired
	private CidadeRepository repo;
	
	public DataPage<Cidade> getCidades(Integer pagina) {
		return new DataPage<>(repo.findAll(pageRequestForAsc(pagina, "nome")));
	}

	public void salvar(Cidade cidade) {
		repo.save(cidade);
	}

	public Cidade recuperarPeloId(Long id) {
		return repo.findOne(id);
	}

	public void remover(Cidade cidade) {
		repo.delete(cidade);		
	}

	public List<Cidade> getTodasCidades() {
		return repo.findAll(new Sort(new Sort.Order(ASC, "nome")));
	}

        public Cidade carregar(Long id) {
                return repo.findOne(id);
        }

}
