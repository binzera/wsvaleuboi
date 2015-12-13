package br.gms.wsvaleuboi.persistence;

import java.util.List;

import javax.persistence.TypedQuery;

import br.gms.wsvaleuboi.entity.Fazenda;
import br.gms.wsvaleuboi.entity.LoteGado;
import br.gms.wsvaleuboi.entity.Usuario;
import br.gov.frameworkdemoiselle.template.JPACrud;

public class LoteDAO extends JPACrud<LoteGado, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public boolean isExisteLote(LoteGado lote){
		
//		CriteriaQuery<Fazenda> criteria = getEntityManager().getCriteriaBuilder().createQuery(Fazenda.class);
//		
//		criteria.
//		
//		this.findByCriteriaQuery(criteriaQuery)
		
		boolean retorno = false;
		
		StringBuffer ql = new StringBuffer();
		ql.append(" from LoteGado l ");
		ql.append(" where l.qtdGado = :qtdGado ");
		ql.append(" and l.fazenda = :fazenda ");
		ql.append(" and l.idade = :idade ");
		ql.append(" and l.racaGado = :raca ");
		ql.append(" and l.usuario = :usuario");
		
		TypedQuery<LoteGado> query = getEntityManager().createQuery(ql.toString(), LoteGado.class);
		query.setParameter("qtdGado", lote.getQtdGado());
		query.setParameter("fazenda", lote.getFazenda());
		query.setParameter("idade", lote.getIdade());
		query.setParameter("raca", lote.getRacaGado());
		query.setParameter("usuario", lote.getUsuario());
		
		List<LoteGado> lista = query.getResultList();
		
		if(!lista.isEmpty()){
			retorno = true;
		}
		
		return retorno;
		
	}

	public List<LoteGado> findByUserId(Usuario user) {
		StringBuffer ql = new StringBuffer();
		ql.append("  from LoteGado l ");
		ql.append(" where l.usuario = :usuario ");

		TypedQuery<LoteGado> query = getEntityManager().createQuery(ql.toString(), LoteGado.class);
		query.setParameter("usuario", user);

		return query.getResultList();
	}
	
	
}
