package br.gms.wsvaleuboi.business;

import java.util.List;

import javax.inject.Inject;

import br.gms.wsvaleuboi.entity.RacaGado;
import br.gms.wsvaleuboi.persistence.RacaGadoDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class RacaGadoBC extends DelegateCrud<RacaGado, Long, RacaGadoDAO> {
	
	@Inject
	private RacaGadoDAO dao;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public List<RacaGado> findByName(RacaGado raca){
		
		return dao.findByName(raca.getNome());
		
	}

}
