package br.gms.wsvaleuboi.rest;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.gms.wsvaleuboi.entity.Usuario;
import br.gms.wsvaleuboi.util.JPAUtil;


public class UsuarioTest{

	
	private static EntityManager em;
	
	
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
	
	@Test
	public void insertUser(){
//		Usuario user = new Usuario();
//		user.setEmail("tixa@gmail.com");
//		user.setNome("Gustavo");
//		user.setSenha("soh");
//		user.setUsuario("tixa");
//		user = em.merge(user);
		
		
		Usuario user2 = new Usuario();
		user2.setEmail("glaubert@gmail.com");
		user2.setNome("Glaubert");
		user2.setSenha("soh");
		user2.setUsuario("binzera");
		user2 = em.merge(user2);
	}

}
