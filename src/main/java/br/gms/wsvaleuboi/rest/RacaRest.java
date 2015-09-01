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

import br.gms.wsvaleuboi.business.RacaGadoBC;
import br.gms.wsvaleuboi.entity.RacaGado;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ValidatePayload;

@Path("")
public class RacaRest {
	
	@Inject
	private RacaGadoBC bc;
	
	@POST
	@Path("inserirRaca")
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")
	public Response insert(RacaGado entity) throws Exception {
		String retorno = "";
		
		List<RacaGado> lista = bc.findByName(entity);
		
		if(lista.isEmpty()){
			try{
				entity = bc.insert(entity);
				if(entity.getId() != null) {
					retorno = "CADASTRO_RACA_SUCESSO";
				}
			} catch(Exception e){
				retorno = "ERRO_CADASTRO_RACA";
				System.out.println("Erro: " + e.getMessage());
			}		
		} else {
			retorno = "RACA_JA_EXISTE";
		}	
		
		return Response.ok(retorno)
				.type(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.build();
	}
	
	
	
	@GET
	@Path("racas")
	@Produces("application/json")
	public List<RacaGado> getRacasGado() throws Exception {
		return bc.findAll();
	}

}
