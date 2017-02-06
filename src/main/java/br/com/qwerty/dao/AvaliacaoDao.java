package br.com.qwerty.dao;

import br.com.qwerty.entidade.Avaliacao;

public class AvaliacaoDao extends GenericDao<Avaliacao, Integer> {

	public AvaliacaoDao() {
		super(Avaliacao.class);
	}
}
