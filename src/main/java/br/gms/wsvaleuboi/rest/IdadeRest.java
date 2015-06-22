package br.gms.wsvaleuboi.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.gms.wsvaleuboi.business.IdadeBC;
import br.gms.wsvaleuboi.entity.Idade;

@Path("")
public class IdadeRest {
	
	@Inject
	private IdadeBC bc;
	
	@GET
	@Path("idades")
	@Produces("application/json")
	public List<Idade> getTipoMovimentacoes(){
		return bc.findAll();
	}

}
