package cat.itacademy.barcelonactiva.arisogorostizaga.toni.s04.t02.n01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s04.t02.n01.model.services.FruitaService;

@RestController
@RequestMapping("/fruita")
public class FruitaController {
	
	@Autowired
	FruitaService fruitaService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addFruita(Fruita fruita) {
		try {
			fruita = new Fruita(fruita.getId(), fruita.getNom(), fruita.getQuantitatQuilos());
			fruitaService.addFruita(fruita);
			return new ResponseEntity<>("Fruita afegida.", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Fruita> getFruitaById(@PathVariable("id") int id) {
		
		try {
			Fruita fruita = fruitaService.getFruitaById(id);
			if (fruita != null) {
				return new ResponseEntity<>(fruita, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAll")	
	public ResponseEntity<?> getAllFruita() {
		if(fruitaService.getAllFruita().isEmpty()) {
			return new ResponseEntity<>("No hi ha fruites.", HttpStatus.OK);
		}
		return new ResponseEntity<List<Fruita>>(fruitaService.getAllFruita(), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateFruita(Fruita fruita){
		
		if(fruitaService.getFruitaById(fruita.getId()) == null) {	
			return new ResponseEntity<>("No existeix aquesta fruita.", HttpStatus.BAD_REQUEST);
		} else {
			fruitaService.updateFruita(fruita);
			return new ResponseEntity<>("La fruita s'ha actualitzat correctament.", HttpStatus.OK);
		}
		
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteFruitaById(@PathVariable("id") int id){
		
		if(fruitaService.getFruitaById(id) == null) {	
			return new ResponseEntity<>("No existeix aquesta fruita.", HttpStatus.BAD_REQUEST);
		} else {
			
			fruitaService.deleteFruitaById(id);	
			return new ResponseEntity<>("Fruita esborrada.", HttpStatus.OK);
		}
	}
}
