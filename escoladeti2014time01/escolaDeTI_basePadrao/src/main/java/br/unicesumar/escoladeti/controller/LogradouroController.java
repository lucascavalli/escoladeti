package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Logradouro;
import br.unicesumar.escoladeti.service.LogradouroService;
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
@RequestMapping("/rest/logradouro")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class LogradouroController implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(LogradouroController.class);

    @Autowired
    private LogradouroService service;

    public LogradouroService getService() {
        return service;
    }

    @RequestMapping(value = {"/listar"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Logradouro> listar() {   	
    	return service.getLogradouros(0);
    }
    
    @RequestMapping(value = {"/listar/pag/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Logradouro> listar(@PathVariable Integer pagina) {   	
    	return service.getLogradouros(pagina);
    }

    @RequestMapping(value = "/remover", method = RequestMethod.DELETE)
    @ResponseBody
    public String remover(@RequestBody Logradouro logradouro) {
    	service.remover(logradouro);
    	return "OK";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    @ResponseBody
    public String salvar(@RequestBody Logradouro logradouro) {
    	service.salvar(logradouro);
    	return "OK";
    }

    @RequestMapping(value = "/localiza", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public Logradouro localiza(@RequestParam Long id) {
		logger.debug("Id a localizar: {}", id);
    	return service.recuperarPeloId(id);
    }

    @RequestMapping(value = {"/todos"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Logradouro> todos() {   	
    	return service.getTodosLogradouros();
    }
    
    @RequestMapping(value = "/carregar/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Logradouro carregar(@PathVariable Long id) {
    	return service.carregar(id);
    }
}
