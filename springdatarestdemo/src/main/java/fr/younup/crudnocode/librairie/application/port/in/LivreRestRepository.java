package fr.younup.crudnocode.librairie.application.port.in;

import fr.younup.crudnocode.librairie.adapter.out.persistence.Livre;
import fr.younup.crudnocode.librairie.application.port.out.LivreDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LivreRestRepository extends CrudRepository<Livre, Long> {
}
