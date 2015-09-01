package br.gms.wsvaleuboi.persistence;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.SQLQuery;

import br.gms.wsvaleuboi.entity.Fazenda;
import br.gms.wsvaleuboi.entity.Usuario;
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
	
	
	public List<Fazenda> findByUserId(Usuario user) {
		
		StringBuffer ql = new StringBuffer();
		ql.append("  from Fazenda f ");
		ql.append(" where f.usuario = :usuario ");

		TypedQuery<Fazenda> query = getEntityManager().createQuery(ql.toString(), Fazenda.class);
		query.setParameter("usuario", user);
		
		List<Fazenda> results = query.getResultList();
		
//		String sql = "SELECT * FROM fazenda WHERE usuario_id = " + user.getId();
//		Query query = getEntityManager().createNativeQuery(sql);
//		List<Fazenda> results = query.getResultList();

		return results;
	}
	
}
