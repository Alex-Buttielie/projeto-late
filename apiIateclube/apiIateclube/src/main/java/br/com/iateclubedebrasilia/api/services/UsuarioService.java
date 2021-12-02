package br.com.iateclubedebrasilia.api.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.iateclubedebrasilia.api.domain.enums.Perfil;
import br.com.iateclubedebrasilia.api.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iateclubedebrasilia.api.domain.Usuario;
import br.com.iateclubedebrasilia.api.domain.enums.Perfil;
import br.com.iateclubedebrasilia.api.dto.UsuarioDTO;
import br.com.iateclubedebrasilia.api.dto.UsuarioNewDTO;
import br.com.iateclubedebrasilia.api.repositories.UsuarioRepository;
import br.com.iateclubedebrasilia.api.security.UserSS;
import br.com.iateclubedebrasilia.api.services.exceptions.AuthorizationException;
import br.com.iateclubedebrasilia.api.services.exceptions.DataIntegrityException;
import br.com.iateclubedebrasilia.api.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;

	@Autowired
	private BCryptPasswordEncoder pe;

	@Value("${img.prefix.client.profile}")
	private String prefix;
	
	@Value("${img.profile.size}")
	private Integer size;
	
	public Usuario find(Integer id) {
		
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	@Transactional
	public Usuario insert(Usuario obj) {
		obj.setUsuIden(null);
		obj.setUsuario(find(UserService.authenticated().getId()));
		obj = repo.save(obj);
		return obj;
	}
	
	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getUsuIden());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}
	
	public List<Usuario> findAll() {
		return repo.findAll();
	}
	
	public Usuario findByEmail(String email) {
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}
	
		Usuario obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Usuario.class.getName());
		}
		return obj;
	}
	
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}
	
	public Usuario fromDTO(UsuarioNewDTO objDto) {
		Usuario usu = new Usuario(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), pe.encode(objDto.getSenha()));
		return usu;
	}
	
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}





	public ResponseEntity salvar(Usuario usuario) {
		return Optional
				.ofNullable(definirSenhaUsuarioESalvar(usuario))
				.map(usuariosalvo ->{
					Map<String, Usuario> resposta =  new HashMap<>();
					resposta.put("Registro salvo", usuariosalvo);
					return  ResponseEntity.ok(resposta);
				}).orElseThrow(()-> new NullPointerException( "Nao foi possivel realizar o cadastro!"));
	}


	private Usuario definirSenhaUsuarioESalvar(Usuario usuario) {

		return Optional.ofNullable(usuario)
				.map(user -> setSenhaSalvaUsuer(user))
				.orElse(null);

	}

	private Usuario setSenhaSalvaUsuer(Usuario user) {
		String newPass = Util.newPassword();
		user.setSenha(pe.encode(newPass));
		return repo.save(user);
	}

	public List<Usuario> listar(){
		return Optional
				.ofNullable(repo.findAll())
				.orElseThrow(() -> new NullPointerException("Nao exitem Usuarios cadastrados"));
	}

	public Usuario pesquisarUsuario(Integer id) {
		return Optional
				.ofNullable(id)
				.map(idConsultado-> repo.findById(idConsultado).orElse(null))
				.orElseThrow(() -> new NullPointerException("Usuario nao encontrado"));
	}

	public ResponseEntity deletarUsuario(Integer id) {
		return Optional
				.ofNullable(repo.findById(id).orElse(null))
				.map(usuarioConsultado-> {
					repo.delete(usuarioConsultado);
					return ResponseEntity.ok("Registro excluíudo");
				}).orElseThrow(()-> new NullPointerException("Usuario nao encontrado para exclus�o"));
	}

	public List<Usuario> alterarUsuarios(List<Usuario> listaDeUsuarios) {
		return Optional
				.ofNullable(Util.isListaObjVazia(listaDeUsuarios))
				.map(listaValidada-> repo.saveAll(listaDeUsuarios))
				.orElseThrow(()-> new NullPointerException("Informe pelo menos um usuario para ser alterado"));
	}

	public Usuario alterarUsuario(Usuario usuario, Integer id){
		return Optional
				.ofNullable(repo.findById(id).orElse(null))
				.map(usuarioConsultado-> {
					usuario.setUsuIden(usuarioConsultado.getUsuIden());
					return repo.save(usuario);
				}).orElseThrow(()-> new NullPointerException("Nao foi possivel realizar a alteracao"));

	}

}
