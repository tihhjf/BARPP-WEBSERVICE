package br.com.qwerty.service;

import java.util.List;

import br.com.qwerty.dao.UsuarioDao;
import br.com.qwerty.entidade.Usuario;
import br.com.qwerty.exception.UsuarioValidator;

public class UsuarioService {

	UsuarioDao usuarioDao = new UsuarioDao();

	public void salvar(Usuario usuario) {
		UsuarioValidator.validarEmailJaCadastrado(usuario);
		usuarioDao.salvar(usuario);
	}

	public void atualizar(Usuario usuario) {
		usuarioDao.atualizar(usuario);
	}

	public Usuario buscar(int id) {
		return usuarioDao.buscarPorId(id);
	}
	
	public Usuario login(Usuario usuario) {
		return usuarioDao.login(usuario.getEmail(), usuario.getSenha());
	}
	
	public Usuario buscarPorEmail(Usuario usuario) {
		return usuarioDao.buscarPorEmail(usuario.getEmail());
	}

	public List<Usuario> buscarTodos() {
		return usuarioDao.buscarTodos();
	}

	public void remover(int id) {
		usuarioDao.remover(id);
	}
}
