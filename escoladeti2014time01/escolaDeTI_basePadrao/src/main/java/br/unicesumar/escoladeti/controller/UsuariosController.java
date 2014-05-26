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

import br.unicesumar.escoladeti.entity.Usuario;
import br.unicesumar.escoladeti.service.UsuarioService;

@Controller
@RequestMapping("/rest/usuario")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class UsuariosController implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(UsuariosController.class);

    @Autowired
    private UsuarioService service;

    public UsuarioService getService() {
        return service;
    }

    @RequestMapping(value = {"/listar"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Usuario> listar() {   	
    	return service.getUsuarios(0);
    }
    
    @RequestMapping(value = {"/listar/pag/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Usuario> listar(@PathVariable Integer pagina) {   	
    	return service.getUsuarios(pagina);
    }

    @RequestMapping(value = "/remover", method = RequestMethod.DELETE)
    @ResponseBody
    public String remover(@RequestBody Usuario usuario) {
    	service.remover(usuario);
    	return "OK";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    @ResponseBody
    public String salvar(@RequestBody Usuario usuario) {
    	service.salvar(usuario);
    	return "OK";
    }

    @RequestMapping(value = "/localiza", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public Usuario localiza(@RequestParam Long id) {
    	logger.debug("Id a localizar: {}", id);
    	return service.recuperarPeloId(id);
    }

    @RequestMapping(value = {"/todos"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Usuario> todos() {   	
    	return service.getTodosUsuarios();
    }
    
    @RequestMapping(value = "/carregar/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Usuario carregar(@PathVariable Long id) {
    	return service.carregar(id);
    }
}
