package br.unicesumar.escoladeti.service;

import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import static org.springframework.data.domain.Sort.Direction.ASC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.entity.Distrito;
import br.unicesumar.escoladeti.repository.DistritoRepository;

@Service
public class DistritoService {
	@Autowired
	private DistritoRepository repo;
	
	public DataPage<Distrito> getDistritos(Integer pagina) {
		return new DataPage<>(repo.findAll(pageRequestForAsc(pagina, "nome")));
	}

	public void salvar(Distrito distrito) {
		repo.save(distrito);
	}

	public Distrito recuperarPeloId(Long id) {
		return repo.findOne(id);
	}

	public void remover(Distrito distrito) {
		repo.delete(distrito);		
	}

	public List<Distrito> getTodosDistritos() {
		return repo.findAll(new Sort(new Sort.Order(ASC, "nome")));
	}

        public Distrito carregar(Long id) {
                return repo.findOne(id);
        }

}
