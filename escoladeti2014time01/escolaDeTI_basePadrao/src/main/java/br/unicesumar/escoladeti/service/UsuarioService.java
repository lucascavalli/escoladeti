package br.unicesumar.escoladeti.service;

import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import static org.springframework.data.domain.Sort.Direction.ASC;

import java.util.List;

import org.springframework.data.domain.Sort;
import br.unicesumar.escoladeti.controller.DataPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.unicesumar.escoladeti.entity.Usuario;
import br.unicesumar.escoladeti.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void inicializarUsuarioAdmin() {
		logger.info("Verificando existência do usuário 'admin'...");
		Usuario root = getUsuarioRepository().findByLogin("admin");
		if (root == null) {
			logger.info("Usuário 'admin' não encontrado, criando...");

			root = new Usuario();
			root.setLogin("admin");
			root.setSenha("123mudar");
			root.setAtivo(true);
			
			logger.debug("Salvando {}", root);
			getUsuarioRepository().save(root);
			
			//inicializarUsuarios();
		}
		logger.info("Usuário 'admin' verificado.");
	}

	/*private void inicializarUsuarios() {
		Usuario novo = null;
		for (int i = 1; i <= 50000; i++) {
			novo = new Usuario();
			novo.setLogin("login_" + i);
			novo.setSenha("senha_" + i);
			novo.setAtivo(Boolean.TRUE);

			logger.debug("Salvando {}", novo);
			getUsuarioRepository().save(novo);
		}
	}*/
        
        
	public DataPage<Usuario> getUsuarios(Integer pagina) {
		return new DataPage<>(usuarioRepository.findAll(pageRequestForAsc(pagina, "login")));
	}

	public void salvar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public Usuario recuperarPeloId(Long id) {
		return usuarioRepository.findOne(id);
	}

	public void remover(Usuario usuario) {
		usuarioRepository.delete(usuario);		
	}

	public List<Usuario> getTodosUsuarios() {
		return usuarioRepository.findAll(new Sort(new Sort.Order(ASC, "login")));
	}

        public Usuario carregar(Long id) {
                return usuarioRepository.findOne(id);
        }
        

}
