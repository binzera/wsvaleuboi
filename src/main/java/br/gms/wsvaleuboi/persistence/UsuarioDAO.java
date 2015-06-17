package br.gms.wsvaleuboi.persistence;

import java.util.List;

import javax.persistence.TypedQuery;

import br.gms.wsvaleuboi.entity.Usuario;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Long> {
	
	private static final long serialVersionUID = 1L;

	public List<Usuario> findByUserName(String userName) {
		StringBuffer ql = new StringBuffer();
		ql.append("  from Usuario b ");
		ql.append(" where lower(b.usuario) = :usuario ");

		TypedQuery<Usuario> query = getEntityManager().createQuery(ql.toString(), Usuario.class);
		query.setParameter("usuario", userName.toLowerCase().trim());

		return query.getResultList();
	}


}
