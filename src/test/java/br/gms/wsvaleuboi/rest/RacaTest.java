package br.gms.wsvaleuboi.rest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.gms.wsvaleuboi.entity.RacaGado;

public class RacaTest extends AbstractTest {
	
	@Test
	public void insertUser(){
		RacaGado raca = new RacaGado();
		raca.setNome("Holandes 2");
		em.persist(raca);
	}

}
