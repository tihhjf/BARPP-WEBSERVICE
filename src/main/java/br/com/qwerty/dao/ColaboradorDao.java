package br.com.qwerty.dao;

import br.com.qwerty.entidade.Colaborador;

public class ColaboradorDao extends GenericDao<Colaborador, Integer>{

	public ColaboradorDao() {
		super(Colaborador.class);
	}
}
