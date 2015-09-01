package br.gms.wsvaleuboi.rest;

import java.net.URI;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.gms.wsvaleuboi.business.UsuarioBC;
import br.gms.wsvaleuboi.entity.Usuario;
import br.gov.frameworkdemoiselle.BadRequestException;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Beans;
import br.gov.frameworkdemoiselle.util.ValidatePayload;

@Path("")
public class SiscofaREST {
	
	@Inject
	private UsuarioBC bc;
	
	@POST
	//@LoggedIn
	@Path("cadastrarUsuario")
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")
	public Response cadastrarUsuario(Usuario body, @Context UriInfo uriInfo) throws Exception {
		checkId(body);
		
		Object retorno = bc.cadastrarUsuario(body);
		
		return Response.ok(retorno)
		.type(MediaType.APPLICATION_JSON)
		.header("Access-Control-Allow-Origin", "*")
		.build();
		//return Response.created(location).entity(id).build();
	}
	
	@POST
	//@LoggedIn
	@Path("logar")
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")
	public Response logar(Usuario body, @Context UriInfo uriInfo) throws Exception {
		checkId(body);
		
		Object retorno = bc.logar(body);
		
		return Response.ok(retorno)
				.type(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.build();
	}
	
	
	@GET
	@Path("teste")
	@Produces("application/json")
	public Usuario teste() throws Exception {
		Usuario result = new Usuario();
		result.setEmail("zeh@gmail");
		result.setNome("nome");
		result.setId(123);
		result.setNome("binzera");
		return result;
	}
	
	@GET
	@Path("testeUser")
	@Produces("application/json")
	public Usuario testeUser() throws Exception {
		Usuario result = new Usuario();
		result.setEmail("zeh@gmail");
		result.setNome("nome");
		result.setId(123);
		result.setNome("binzera");
		result.setUsuario("asdf");
		return result;
	}
	
	private void checkId(Usuario entity) throws Exception {
		if (entity.getId() != null) {
			throw new BadRequestException();
		}
	}

}
