package br.com.qwerty.business;

public enum BusinessCode {

	SUCESSO(0, "Sucesso!"),
	SUCESSO_SALVAR(0, "Registro salvo com sucesso!"),
	SUCESSO_ATUALIZAR(0, "Registro atualizado com sucesso!"),
	SUCESSO_REMOVER(0, "Registro removido com sucesso!"),
	
	INTERNAL_ERROR(1, "Erro de negocio"),
	INTERNAL_ERROR_SALVAR(2, "Erro ao salvar o registro"),
	INTERNAL_ERROR_ATUALIZAR(3, "Erro ao atualizar o registro"),
	INTERNAL_ERROR_REMOVER(4, "Erro ao remover o registro"),
	
	ERRO_USUARIO_NOME_VAZIO(5, "Nome Usuário não pode estar vazio."),
	ERRO_LOGIN_INVALIDO(6, "E-mail ou senha inválidos."),
	ERRO_NENHUM_REGISTRO(7, "Nenhum registro encontrado."),
	ERRO_EMAIL_JA_CADASTRADO(8, "Ja existe um cadastro com o e-mail informado.");
	
	
	private int codigo;
	private String mensagem;
	
	private BusinessCode(int codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

}
