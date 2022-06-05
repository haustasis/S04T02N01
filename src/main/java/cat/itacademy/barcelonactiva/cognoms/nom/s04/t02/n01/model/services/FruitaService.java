package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.model.repository.FruitaRepository;

@Service
public class FruitaService {
	@Autowired
	private FruitaRepository fruitaRepository;
	
	@Transactional
	public Fruita addFruita(Fruita fruita) {
		return fruitaRepository.save(fruita);
	}
	
	@Transactional
	public Fruita getFruitaById(int id) {
		return fruitaRepository.findById(id).orElse(null);
	}
	
	@Transactional
	public List<Fruita> getAllFruita() {
		return fruitaRepository.findAll();
	}
	
	@Transactional
	public Fruita updateFruita(Fruita fruita) {
		Fruita fruitaInitial = null;
		Optional<Fruita> optionalFruita = fruitaRepository.findById(fruita.getId());
		if(optionalFruita.isPresent()) {
			fruitaInitial = optionalFruita.get();
			fruitaInitial.setNom(fruita.getNom());
			fruitaInitial.setQuantitatQuilos(fruita.getQuantitatQuilos());
			fruitaRepository.save(fruitaInitial);
		} else {
			return new Fruita();
		}

		return fruitaInitial;
	}
	
	@Transactional
	public String deleteFruitaById(int id) {
		fruitaRepository.deleteById(id);
		return "S'ha esborrat la fruita";
	}
	
	
}
