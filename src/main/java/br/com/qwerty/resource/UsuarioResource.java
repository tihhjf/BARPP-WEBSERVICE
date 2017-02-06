package br.com.qwerty.resource;

import java.util.List;

import javax.persistence.NoResultException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.qwerty.business.BusinessCode;
import br.com.qwerty.dto.BasicResponseDTO;
import br.com.qwerty.entidade.Usuario;
import br.com.qwerty.exception.ValidacaoException;
import br.com.qwerty.service.UsuarioService;

@Path("/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {
	
	UsuarioService UsuarioService = new UsuarioService();

	@GET
	@Path("/buscar")
	public List<Usuario> buscarTodos() {
		return UsuarioService.buscarTodos(); 
	}
	
	@GET
	@Path("/buscar/{id}")
	public Usuario buscar(@PathParam("id") int id) {
		return UsuarioService.buscar(id); 
	}
	
	@POST
	@Path("/login")
	public Object login(Usuario usuario) {
		try {
			return UsuarioService.login(usuario); 
		} catch (NoResultException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(BasicResponseDTO.createResponse(BusinessCode.ERRO_LOGIN_INVALIDO))
					.build();
		}
	}
	
	@POST
	@Path("/salvar")
	public Response salvar(Usuario usuario){
		try{
			UsuarioService.salvar(usuario);
			return Response.status(Status.CREATED)
					.entity(BasicResponseDTO.createResponse(BusinessCode.SUCESSO_SALVAR))
					.build();
		} catch (ValidacaoException e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(e.getBasicResponse())
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(BasicResponseDTO.createResponse(BusinessCode.INTERNAL_ERROR_SALVAR))
					.build();
		}
	}
	
	@PUT
	@Path("/atualizar")
	public Response atualizar(Usuario usuario){
		try{
			UsuarioService.atualizar(usuario);
			return Response.status(Status.OK)
					.entity(BasicResponseDTO.createResponse(BusinessCode.SUCESSO_ATUALIZAR))
					.build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(BasicResponseDTO.createResponse(BusinessCode.INTERNAL_ERROR_ATUALIZAR))
					.build();
		}
	}
	
	@DELETE
	@Path("/remover/{id}")
	public Response remover(@PathParam("id") int id){
		try{
			UsuarioService.remover(id);
			return Response.status(Status.OK)
					.entity(BasicResponseDTO.createResponse(BusinessCode.SUCESSO_REMOVER))
					.build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(BasicResponseDTO.createResponse(BusinessCode.INTERNAL_ERROR_REMOVER))
					.build();
		}
	}
}
