package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.entity.Cidade;
import br.unicesumar.escoladeti.entity.Distrito;
import br.unicesumar.escoladeti.service.CidadeService;
import br.unicesumar.escoladeti.service.DistritoService;
import java.io.Serializable;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

@Controller
@RequestMapping("/rest/cidade")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class CidadeController implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(CidadeController.class);
    
    @Autowired
    private CidadeService serviceCidade;
    @Autowired
    private DistritoService serviceDistrito;
    
    public CidadeService getService(){
        return serviceCidade;
    }
 
    @RequestMapping(value = {"/listar"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Cidade> listar(){
        return serviceCidade.getCidades(0);
    }
    
    @RequestMapping(value = {"/listar/pag/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Cidade> listar(@PathVariable Integer pagina){
        return serviceCidade.getCidades(pagina);
    }
    
    @RequestMapping(value = {"/remover"}, method = RequestMethod.DELETE)
    @ResponseBody
    public String remover(@RequestBody Cidade cidade, @RequestBody Distrito distrito){
        serviceDistrito.remover(distrito);
        serviceCidade.remover(cidade);
        return "OK";
    }
    
    @RequestMapping(value = {"/salvar"}, method = RequestMethod.POST)
    @ResponseBody
    public String salvar(@RequestBody Cidade cidade, @RequestBody Distrito distrito){
        serviceDistrito.salvar(distrito);
        serviceCidade.salvar(cidade);
        return "OK";
    }
    
    @RequestMapping(value = {"/localiza"}, params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public Cidade localiza(@RequestParam Long id){
        logger.debug("Id a localizar: {}", id);
        return serviceCidade.recuperarPeloId(id);
    }
    
    @RequestMapping(value = {"/todas"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Cidade> todas(){
        return serviceCidade.getTodasCidades();
    }
    
    @RequestMapping(value = {"/carregar/{id}"}, method = RequestMethod.GET)
    @ResponseBody
    public Cidade carregar(@PathVariable Long id){
        return serviceCidade.carregar(id);
    }
    
    
}
