package br.gms.wsvaleuboi.persistence;

import java.util.List;

import javax.persistence.TypedQuery;

import br.gms.wsvaleuboi.entity.RacaGado;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class RacaGadoDAO extends JPACrud<RacaGado, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public List<RacaGado> findByName(String nomeRaca) {
		StringBuffer ql = new StringBuffer();
		ql.append("  from RacaGado b ");
		ql.append(" where lower(b.nome) = :nomeRaca ");

		TypedQuery<RacaGado> query = getEntityManager().createQuery(ql.toString(), RacaGado.class);
		query.setParameter("nomeRaca", nomeRaca.toLowerCase().trim());

		return query.getResultList();
	}

}
