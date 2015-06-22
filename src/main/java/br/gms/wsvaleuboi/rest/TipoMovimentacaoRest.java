package br.gms.wsvaleuboi.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.gms.wsvaleuboi.business.TipoMovimentacaoBC;
import br.gms.wsvaleuboi.entity.TipoMovimentacao;

@Path("")
public class TipoMovimentacaoRest {

	@Inject
	TipoMovimentacaoBC bc;
	
	
	@GET
	@Path("tipoMovimentacoes")
	@Produces("application/json")
	public List<TipoMovimentacao> getTipoMovimentacoes(){
		return bc.findAll();
	}
}
