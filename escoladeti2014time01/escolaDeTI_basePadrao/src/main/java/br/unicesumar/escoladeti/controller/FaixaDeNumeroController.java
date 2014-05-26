package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.FaixaDeNumero;
import br.unicesumar.escoladeti.service.FaixaDeNumeroService;
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
@RequestMapping("/rest/faixadenumero")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class FaixaDeNumeroController implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(FaixaDeNumeroController.class);

    @Autowired
    private FaixaDeNumeroService service;

    public FaixaDeNumeroService getService() {
        return service;
    }

    @RequestMapping(value = {"/listar"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<FaixaDeNumero> listar() {   	
    	return service.getFaixasDeNumero(0);
    }
    
    @RequestMapping(value = {"/listar/pag/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<FaixaDeNumero> listar(@PathVariable Integer pagina) {   	
    	return service.getFaixasDeNumero(pagina);
    }

    @RequestMapping(value = "/remover", method = RequestMethod.DELETE)
    @ResponseBody
    public String remover(@RequestBody FaixaDeNumero faixaDeNumero) {
    	service.remover(faixaDeNumero);
    	return "OK";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    @ResponseBody
    public String salvar(@RequestBody FaixaDeNumero faixaDeNumero) {
    	service.salvar(faixaDeNumero);
    	return "OK";
    }

    @RequestMapping(value = "/localiza", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public FaixaDeNumero localiza(@RequestParam Long id) {
        logger.debug("Id a localizar: {}", id);
    	return service.recuperarPeloId(id);
    }

    @RequestMapping(value = {"/todos"}, method = RequestMethod.GET)
    @ResponseBody
    public List<FaixaDeNumero> todas() {   	
    	return service.getTodasFaixasDeNumero();
    }
    
    @RequestMapping(value = "/carregar/{id}", method = RequestMethod.GET)
    @ResponseBody
    public FaixaDeNumero carregar(@PathVariable Long id) {
    	return service.carregar(id);
    }
}
