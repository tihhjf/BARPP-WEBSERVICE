package br.com.qwerty.service;

import java.util.List;

import br.com.qwerty.dao.ImagemDao;
import br.com.qwerty.entidade.Imagem;

public class ImagemService {

	ImagemDao imagemDao = new ImagemDao();
	
	public void salvar(Imagem imagem){
		imagemDao.salvar(imagem);
	}
	
	public void atualizar(Imagem imagem){
		imagemDao.atualizar(imagem);
	}
	
	public Imagem buscar(int id){
		return imagemDao.buscarPorId(id);
	}
	
	public List<Imagem> buscarTodos(){
		return imagemDao.buscarTodos();
	}
	
	public void remover(int id){
		imagemDao.remover(id);
	}
}
