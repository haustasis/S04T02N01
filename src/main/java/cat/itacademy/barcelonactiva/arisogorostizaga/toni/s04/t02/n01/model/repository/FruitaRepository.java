package cat.itacademy.barcelonactiva.arisogorostizaga.toni.s04.t02.n01.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s04.t02.n01.model.domain.Fruita;

@Repository
public interface FruitaRepository extends JpaRepository<Fruita, Integer> {
	 
}
