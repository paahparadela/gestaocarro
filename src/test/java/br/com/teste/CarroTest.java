package br.com.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarroTest {
	
	@Test
	public void carroModelTest() {
		Carro carro = new Carro();
		carro.setChassi((long) 1);
		carro.setCor("branco");
		carro.setMarca("hyundai");
		carro.setModelo("hb 20");
		carro.setMotor(1.4);
		carro.setQuantidadePorta(4);
		
		assertEquals((long) 1, carro.getChassi());
		assertEquals("branco", carro.getCor());
		assertEquals("hyundai", carro.getMarca());
		assertEquals("hb 20", carro.getModelo());
		assertEquals(1.4, carro.getMotor());
		assertEquals(4, carro.getQuantidadePorta());
	}

}
