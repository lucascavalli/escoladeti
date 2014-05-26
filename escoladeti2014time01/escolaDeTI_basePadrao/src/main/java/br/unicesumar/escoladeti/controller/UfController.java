package br.unicesumar.escoladeti.controller;

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

import br.unicesumar.escoladeti.entity.Uf;
import br.unicesumar.escoladeti.service.UfService;

@Controller
@RequestMapping("/rest/uf")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class UfController implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(UfController.class);

    @Autowired
    private UfService service;

    public UfService getService() {
        return service;
    }

    @RequestMapping(value = {"/listar"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Uf> listar() {   	
    	return service.getUfs(0);
    }
    
    @RequestMapping(value = {"/listar/pag/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Uf> listar(@PathVariable Integer pagina) {   	
    	return service.getUfs(pagina);
    }

    @RequestMapping(value = "/remover", method = RequestMethod.DELETE)
    @ResponseBody
    public String remover(@RequestBody Uf uf) {
    	service.remover(uf);
    	return "OK";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    @ResponseBody
    public String salvar(@RequestBody Uf uf) {
    	service.salvar(uf);
    	return "OK";
    }

    @RequestMapping(value = "/localiza", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public Uf localiza(@RequestParam Long id) {
    	logger.debug("Id a localizar: {}", id);
    	return service.recuperarPeloId(id);
    }

    @RequestMapping(value = {"/todas"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Uf> todas() {   	
    	return service.getTodasUfs();
    }
    
    @RequestMapping(value = "/carregar/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Uf carregar(@PathVariable Long id) {
    	return service.carregar(id);
    }
}
