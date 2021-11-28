package fr.younup.crudnocode.librairie.adapter.in.web;

import fr.younup.crudnocode.librairie.adapter.out.persistence.LivreMapper;
import fr.younup.crudnocode.librairie.application.port.in.LivreRestRepository;
import fr.younup.crudnocode.librairie.application.port.out.LivreDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public class LivreRest2Repository implements CrudRepository<LivreDto, Long> {

	private final LivreMapper livreMapper;
	private final LivreRestRepository livreRestRepository;

	public LivreRest2Repository(LivreMapper livreMapper, LivreRestRepository livreRestRepository) {
		this.livreMapper = livreMapper;
		this.livreRestRepository = livreRestRepository;
	}

	@Override
	public LivreDto save(LivreDto entity) {
		var po = livreMapper.livreDtoToLivre(entity);
		var opSaved = livreRestRepository.save(po);
		return livreMapper.livreToLivreDto(opSaved);
	}

	@Override
	public <S extends LivreDto> Iterable<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public Optional<LivreDto> findById(Long aLong) {
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long aLong) {
		return false;
	}

	@Override
	public Iterable<LivreDto> findAll() {
		return null;
	}

	@Override
	public Iterable<LivreDto> findAllById(Iterable<Long> longs) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(Long aLong) {

	}

	@Override
	public void delete(LivreDto entity) {

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> longs) {

	}

	@Override
	public void deleteAll(Iterable<? extends LivreDto> entities) {

	}

	@Override
	public void deleteAll() {

	}
}
