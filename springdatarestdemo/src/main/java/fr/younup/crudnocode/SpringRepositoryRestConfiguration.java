package fr.younup.crudnocode;

import fr.younup.crudnocode.librairie.adapter.out.persistence.Livre;
import fr.younup.crudnocode.librairie.application.port.out.LivreDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import java.util.Collection;
import java.util.List;

@Configuration
public class SpringRepositoryRestConfiguration {
	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		return RepositoryRestConfigurer.withConfig(repositoryRestConfiguration ->
				repositoryRestConfiguration.getProjectionConfiguration()
						.addProjection(LivreDto.class, Livre.class));
	}
}
