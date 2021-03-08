package br.com.teste;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gestaocarro")
public class ControllerCarro {
	
	@Autowired
	CarroRepository carroRepository;
	
	@PostMapping("carro")
	public ResponseEntity<?> cadastrarCarro(@RequestBody Carro carro){
		try {
			carroRepository.save(carro);
			return ResponseEntity.created(null).build();
		} catch(Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/carro/{chassi}")
	public ResponseEntity<?> consultarCarro(@PathVariable Long chassi) {
		try {
			Optional<Carro> carro = carroRepository.findById(chassi);
			if(!carro.isPresent()) {
				return ResponseEntity.status(418).build();
			}
			return ResponseEntity.ok(carro);
		}catch(Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/carro/{chassi}")
	public ResponseEntity<?> deletarCarro(@PathVariable Long chassi) {
		try {
			carroRepository.deleteById(chassi);
			return ResponseEntity.ok().build();
		}catch(Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PatchMapping("carro")
	public ResponseEntity<?> atualizarCarro(@RequestBody Carro carro){
		try {
			if(carroRepository.existsById(carro.getChassi())) {
				carroRepository.save(carro);
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.notFound().build();
		} catch(Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
	
//	@GetMapping("/carro")
//	public String getIdRequestParam(@RequestParam String id) {
//	    return "ID: " + id;
//	}
	
//	@GetMapping("/carro/{id}")
//	public String getIdPathParam(@PathParam("id") String id) {
//	    return "ID: " + id;
//	}
	
	@GetMapping("/carro")
	public String getIdMatrixVariable(@MatrixVariable("id") String id) {
	    return "ID: " + id;
	}

}
