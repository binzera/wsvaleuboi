package br.gms.wsvaleuboi.rest;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import br.gms.wsvaleuboi.util.JPAUtil;

public class AbstractTest {
	
	public static EntityManager em;
	
	
	/**
	 * Limpa tabelas a serem testadas
	 */
	@BeforeClass
	public static void cleanup() {
		em = JPAUtil.getEntityManager();

	}

	/**
	 * Inicia Transação para cada método de teste.
	 */
	@Before
	public void iniciaTransacao() {
		em.getTransaction().begin();
	}

	/**
	 * Finaliza Transação para cada método de teste.
	 */
	@After
	public void finalizaTransacao() {
		em.getTransaction().commit();

	}

}
