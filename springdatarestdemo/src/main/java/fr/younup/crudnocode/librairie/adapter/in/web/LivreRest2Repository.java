package fr.younup.crudnocode.librairie.adapter.in.web;

import fr.younup.crudnocode.librairie.adapter.out.persistence.Livre;
import fr.younup.crudnocode.librairie.application.port.out.LivreDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public class LivreRest2Repository implements CrudRepository<Livre, Long> {
}
