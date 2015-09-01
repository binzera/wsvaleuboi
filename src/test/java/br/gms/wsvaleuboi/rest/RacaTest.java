package br.gms.wsvaleuboi.rest;

import org.junit.Test;

import br.gms.wsvaleuboi.entity.RacaGado;

public class RacaTest extends AbstractTest {
	
	@Test
	public void insertUser(){
		RacaGado raca = new RacaGado();
		raca.setNome("Holandes");
		em.persist(raca);
		
		RacaGado raca2 = new RacaGado();
		raca2.setNome("Nelore");
		em.persist(raca2);
		
	
	}

}
