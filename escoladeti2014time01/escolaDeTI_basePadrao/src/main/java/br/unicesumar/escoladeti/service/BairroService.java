package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.Bairro;
import br.unicesumar.escoladeti.repository.BairroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import static org.springframework.data.domain.Sort.Direction.ASC;
import org.springframework.stereotype.Service;

@Service
public class BairroService {
    @Autowired
    private BairroRepository repo;
    
    public DataPage<Bairro> getBairros(Integer pagina){
        return new DataPage<>(repo.findAll(pageRequestForAsc(pagina,"nome")));
    }
    
    public void salvar(Bairro bairro){
       repo.save(bairro);
    }
    
    public Bairro recuperarPeloId(Long id){
        return repo.findOne(id);
    }
    
    public void remover(Bairro bairro){
        repo.delete(bairro);
    }
    
    public List<Bairro> getTodosBairros(){
        return repo.findAll(new Sort(new Sort.Order(ASC,"nome")));
    }
    
    public Bairro carregar(Long id){
        return repo.findOne(id);
    }
}


