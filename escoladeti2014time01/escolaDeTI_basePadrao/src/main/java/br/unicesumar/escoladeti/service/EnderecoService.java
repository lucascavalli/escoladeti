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

import br.unicesumar.escoladeti.entity.Endereco;
import br.unicesumar.escoladeti.repository.EnderecoRepository;

@Service
public class EnderecoService {
   
	private static final Logger logger = LoggerFactory.getLogger(EnderecoService.class);    
	@Autowired
	private EnderecoRepository enderecoRepository;

	public EnderecoRepository getEnderecoRepository() {
		return enderecoRepository;
    }


	/*public void inicializarEnderecoAdmin() {
		logger.info("Verificando existência do endereço");
		//Endereco root = getEnderecoRepository().findByCepContainingOrderByCepAsc("9999");
                Endereco root = (Endereco) getEnderecoRepository().findByCep("9999");
		if (root == null) {
			logger.info("Endereço '9999' não encontrado, criando...");

			root = new Endereco();
			root.setBairro("1");
			root.setCep("9999");
			root.setCidade("1");
                        root.setLogradouro("1");
                        root.setNumero("1");
                        root.setPais("1");
                        root.setUf("1");
			
			logger.debug("Salvando {}", root);
			getEnderecoRepository().save(root);
			
			//inicializarUsuarios();
		}
		logger.info("Endereço padrão verificado.");
	} */

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
        
        public DataPage<Endereco> getEnderecos(Integer pagina) {
		return new DataPage<>(enderecoRepository.findAll(pageRequestForAsc(pagina, "descricao")));
	}

	public void salvar(Endereco endereco) {
		enderecoRepository.save(endereco);
	}

	public Endereco recuperarPeloId(Long id) {
		return enderecoRepository.findOne(id);
	}

	public void remover(Endereco endereco) {
		enderecoRepository.delete(endereco);		
	}

	public List<Endereco> getTodosEnderecos() {
		return enderecoRepository.findAll(new Sort(new Sort.Order(ASC, "numero")));
	}

        public Endereco carregar(Long id) {
                return enderecoRepository.findOne(id);
        }
       

}
