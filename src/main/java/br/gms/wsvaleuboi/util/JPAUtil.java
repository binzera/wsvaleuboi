package br.gms.wsvaleuboi.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe utilitária para operações no contexto do JPA.
 * 
 * @author Marcos Freire (<b>{@code marcos.freire@serpro.gov.br}</b>)
 *
 */
public class JPAUtil {
	
	/**
	 * Constante com o valor do nome da unidade de persistência. Propriedade
	 * presente nas configurações do arquivo {@code persistence.xml}.
	 */
	public static final String PERSISTENCE_UNIT = "siscofaDS-Teste";
	
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	/**
	 * Retorna o contexto de persistência JPA.
	 * 
	 * @return Contexto de Persistência.
	 */
	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

}
