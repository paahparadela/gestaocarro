package br.com.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class ControllerCarroTest {
	
	@Mock
	CarroRepository carroRepository;
	
	@InjectMocks
	ControllerCarro controller;
	
	@Test
	public void cadastrarCarroTest() {
		
		Carro carro = setCarro();
		
		when(carroRepository.save(Mockito.any(Carro.class))).thenReturn(Mockito.any());
		
		ResponseEntity<?> entity = controller.cadastrarCarro(carro);
		
		assertEquals(201, entity.getStatusCodeValue());
	}
	
	@Test
	public void consultarCarroTest() {
		
		Carro carro = setCarro();
		
		when(carroRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(carro));
		
		ResponseEntity<?> entity = controller.consultarCarro((long) 1);
		
		assertEquals(200, entity.getStatusCodeValue());
		assertNotNull(entity.getBody());
	}
	
	@Test
	public void deletarCarroTest() {
		
		ResponseEntity<?> entity = controller.deletarCarro((long) 1);
		
		verify(carroRepository, times(1)).deleteById(Mockito.anyLong());
		
		assertEquals(200, entity.getStatusCodeValue());
	}
	
	@Test
	public void atualizarCarroTest() {
		
		Carro carro = setCarro();
		
		when(carroRepository.existsById(Mockito.anyLong())).thenReturn(true);
		when(carroRepository.save(Mockito.any(Carro.class))).thenReturn(Mockito.any());
		
		ResponseEntity<?> entity = controller.atualizarCarro(carro);
		
		assertEquals(200, entity.getStatusCodeValue());
	}
	
	private Carro setCarro() {
		Carro carro = new Carro();
		carro.setChassi((long) 1);
		carro.setCor("branco");
		carro.setMarca("hyundai");
		carro.setModelo("hb 20");
		carro.setMotor(1.4);
		carro.setQuantidadePorta(4);
		return carro;
	}
}
