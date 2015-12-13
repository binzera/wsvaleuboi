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
import br.gms.wsvaleuboi.business.LoteBC;
import br.gms.wsvaleuboi.entity.Fazenda;
import br.gms.wsvaleuboi.entity.LoteGado;
import br.gms.wsvaleuboi.entity.Usuario;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ValidatePayload;

@Path("")
public class LoteRest {
	
	@Inject
	private LoteBC bc;
	
	
	@POST
	//@LoggedIn
	@Path("cadastrarLote")
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")
	public Response cadastrarLote(LoteGado entity) {
		
		String retorno = bc.cadastrarLote(entity);
		
		return Response.ok(retorno)
				.type(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.build();
		
	}
	
	
	@POST
	//@LoggedIn
	@Path("lotesOfUser")
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")
	public List<LoteGado> getLotesUser(Usuario user) {	
		return bc.findByUserId(user);
		
	}
}
