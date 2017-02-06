package br.com.qwerty.dao;

import br.com.qwerty.entidade.Imagem;

public class ImagemDao extends GenericDao<Imagem, Integer>{

	public ImagemDao() {
		super(Imagem.class);
	}
}
