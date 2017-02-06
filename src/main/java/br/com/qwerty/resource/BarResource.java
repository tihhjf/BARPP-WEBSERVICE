package br.com.qwerty.resource;

import java.util.List;

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
import br.com.qwerty.entidade.Bar;
import br.com.qwerty.service.BarService;

@Path("/bar")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BarResource {
	
	BarService barService = new BarService();
	
	@GET
	@Path("/buscar")
	public List<Bar> buscarTodos() {
		return barService.buscarTodos(); 
	}
	
	@GET
	@Path("/buscar/{id}")
	public Bar buscar(@PathParam("id") int id) {
		return barService.buscar(id); 
	}
	
	@POST
	@Path("/salvar")
	public Response salvar(Bar bar){
		try{
			barService.salvar(bar);
			return Response.status(Status.CREATED)
					.entity(BasicResponseDTO.createResponse(BusinessCode.SUCESSO_SALVAR))
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
	public Response atualizar(Bar bar){
		try{
			barService.atualizar(bar);
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
			barService.remover(id);
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
