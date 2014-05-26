package br.unicesumar.escoladeti.service;

import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import static org.springframework.data.domain.Sort.Direction.ASC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.entity.Uf;
import br.unicesumar.escoladeti.repository.UfRepository;

@Service
public class UfService {
	@Autowired
	private UfRepository repo;
	
	public DataPage<Uf> getUfs(Integer pagina) {
		return new DataPage<>(repo.findAll(pageRequestForAsc(pagina, "nome")));
	}

	public void salvar(Uf uf) {
		repo.save(uf);
	}

	public Uf recuperarPeloId(Long id) {
		return repo.findOne(id);
	}

	public void remover(Uf uf) {
		repo.delete(uf);		
	}

	public List<Uf> getTodasUfs() {
		return repo.findAll(new Sort(new Sort.Order(ASC, "nome")));
	}

        public Uf carregar(Long id) {
                return repo.findOne(id);
        }

}
