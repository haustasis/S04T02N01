package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.model.domain.Fruita;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitaRepository extends JpaRepository<Fruita, Integer> {
	 
	}
