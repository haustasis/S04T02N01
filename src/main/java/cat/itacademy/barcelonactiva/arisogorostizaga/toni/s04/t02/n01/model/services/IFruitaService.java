package cat.itacademy.barcelonactiva.arisogorostizaga.toni.s04.t02.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.arisogorostizaga.toni.s04.t02.n01.model.domain.Fruita;

public interface IFruitaService {

	public Fruita addFruita(Fruita fruita);
	public Fruita getFruitaById(int id);
	public List<Fruita> getAllFruita();
	public Fruita updateFruita(Fruita fruita);
	public String deleteFruitaById(int id);
}
