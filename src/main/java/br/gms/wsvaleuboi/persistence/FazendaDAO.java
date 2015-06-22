package br.gms.wsvaleuboi.persistence;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;

import br.gms.wsvaleuboi.entity.Fazenda;
import br.gms.wsvaleuboi.entity.RacaGado;
import br.gov.frameworkdemoiselle.template.JPACrud;

public class FazendaDAO extends JPACrud<Fazenda, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public boolean isExisteFazenda(Fazenda faz){
		
//		CriteriaQuery<Fazenda> criteria = getEntityManager().getCriteriaBuilder().createQuery(Fazenda.class);
//		
//		criteria.
//		
//		this.findByCriteriaQuery(criteriaQuery)
		
		boolean retorno = false;
		
		StringBuffer ql = new StringBuffer();
		ql.append(" from Fazenda f ");
		ql.append(" where lower(f.nome) = :nomeFaz ");
		ql.append(" and f.usuario = :usuario");
		
		TypedQuery<Fazenda> query = getEntityManager().createQuery(ql.toString(), Fazenda.class);
		query.setParameter("nomeFaz", faz.getNome().toLowerCase().trim());
		query.setParameter("usuario", faz.getUsuario());
		
		List<Fazenda> lista = query.getResultList();
		
		if(!lista.isEmpty()){
			retorno = true;
		}
		
		return retorno;
		
	}
	
}
