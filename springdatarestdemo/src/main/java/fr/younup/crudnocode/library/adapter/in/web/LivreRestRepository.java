package fr.younup.crudnocode.library.adapter.in.web;

import fr.younup.crudnocode.library.adapter.out.persistence.Livre;
import fr.younup.crudnocode.library.application.port.in.LivreDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = LivreDto.class)
public interface LivreRestRepository extends CrudRepository<Livre, Long> {
}
