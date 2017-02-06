package br.com.qwerty.exception;

import br.com.qwerty.business.BusinessCode;
import br.com.qwerty.dto.BasicResponseDTO;
import br.com.qwerty.entidade.Usuario;
import br.com.qwerty.service.UsuarioService;

public class UsuarioValidator {
	
	private static UsuarioService usuarioService = new UsuarioService();
	
	public UsuarioValidator() { }
	
	public static void validarNome(Usuario usuario){
		if (usuario.getNome() == null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_USUARIO_NOME_VAZIO));
		}
	}
	
	public static void validarEmailJaCadastrado(Usuario usuario){
		Usuario u = usuarioService.buscarPorEmail(usuario);
		if (u != null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_EMAIL_JA_CADASTRADO));
		}
	}
}
