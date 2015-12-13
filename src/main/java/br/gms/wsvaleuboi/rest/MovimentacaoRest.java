package br.gms.wsvaleuboi.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.gms.wsvaleuboi.business.MovimentacaoBC;
import br.gms.wsvaleuboi.entity.Fazenda;
import br.gms.wsvaleuboi.entity.MovimentacaoGado;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ValidatePayload;

@Path("")
public class MovimentacaoRest {

	@Inject
	MovimentacaoBC bc;
	
	
	@GET
	@Path("movimentacoes")
	@Produces("application/json")
	public List<MovimentacaoGado> getMovimentacoes(){
		return bc.findAll();
	}
	
	
	@POST
	//@LoggedIn
	@Path("cadastrarMovimentacao")
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")
	public Response cadastrarMovimentacao(MovimentacaoGado entity) {
		
		String retorno = bc.cadastrarMovimentacao(entity);;
		
		return Response.ok(retorno)
				.type(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.build();
		
	}
}
