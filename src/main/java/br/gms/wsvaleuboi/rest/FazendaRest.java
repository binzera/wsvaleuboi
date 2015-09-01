package br.gms.wsvaleuboi.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.gms.wsvaleuboi.business.FazendaBC;
import br.gms.wsvaleuboi.entity.Fazenda;
import br.gms.wsvaleuboi.entity.Usuario;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ValidatePayload;

@Path("")
public class FazendaRest {
	
	@Inject
	private FazendaBC bc;
	
	
	@POST
	//@LoggedIn
	@Path("cadastrarFazenda")
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")
	public Response cadastrarFazenda(Fazenda entity) {
		
		String retorno = bc.cadastrarFazenda(entity);;
		
		return Response.ok(retorno)
				.type(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.build();
		
	}
	
	
	@POST
	//@LoggedIn
	@Path("fazendasOfUser")
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")
	public List<Fazenda> getFazendasUser(Usuario user) {	
		return bc.findByUserId(user);
		
	}
}
