package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Bairro;
import br.unicesumar.escoladeti.service.BairroService;
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
@RequestMapping("/rest/bairro")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class BairroController implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(LogradouroController.class);

    @Autowired
    private BairroService service;
    
    public BairroService getService(){
        return service;
    }
 
    @RequestMapping(value = {"/listar"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Bairro> listar(){
        return service.getBairros(0);
    }
    
    @RequestMapping(value = {"/listar/pag/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Bairro> listar(@PathVariable Integer pagina){
        return service.getBairros(pagina);
    }
    
    @RequestMapping(value = {"/remover"}, method = RequestMethod.DELETE)
    @ResponseBody
    public String remover(@RequestBody Bairro bairro){
        service.remover(bairro);
        return "OK";
    }
    
    @RequestMapping(value = {"/salvar"}, method = RequestMethod.POST)
    @ResponseBody
    public String salvar(@RequestBody Bairro bairro){
        service.salvar(bairro);
        return "OK";
    }
    
    @RequestMapping(value = {"/localiza"}, params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public Bairro localiza(@RequestParam Long id){
        return service.recuperarPeloId(id);
    }
    
    @RequestMapping(value = {"/todos"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Bairro> todos(){
        return service.getTodosBairros();
    }
    
    @RequestMapping(value = {"/carregar/{id}"}, method = RequestMethod.GET)
    @ResponseBody
    public Bairro carregar(@PathVariable Long id){
        return service.carregar(id);
    }
    
    
}
